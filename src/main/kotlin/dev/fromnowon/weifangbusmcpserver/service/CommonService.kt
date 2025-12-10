package dev.fromnowon.weifangbusmcpserver.service

import ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray
import com.fasterxml.jackson.databind.ObjectMapper
import dev.fromnowon.weifangbusmcpserver.constant.APP_KEY
import dev.fromnowon.weifangbusmcpserver.constant.decoder
import dev.fromnowon.weifangbusmcpserver.constant.encoder
import dev.fromnowon.weifangbusmcpserver.param.HData
import dev.fromnowon.weifangbusmcpserver.util.signature
import dev.fromnowon.weifangbusmcpserver.util.sm4
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.crypto.Cipher
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.random.Random

@Service
class CommonService(private val jacksonObjectMapper: ObjectMapper) {

    fun dataenc(data: Any): String = dataSm4Encrypted(data)

    fun hdataenc(): String = dataSm4Encrypted(HData())

    private fun dataSm4Encrypted(any: Any): String = jacksonObjectMapper.writeValueAsString(any).toByteArray().let {
        String(encoder.encode(sm4(Cipher.ENCRYPT_MODE, it)))
    }

    fun sign(payload: String): String {
        val idByteArray = "00000001".toByteArray()
        val payloadByteArray = hexStringToByteArray(payload)
        return String(encoder.encode(signature(idByteArray, payloadByteArray)))
    }

    fun decrypt(dataenc: String): String = String(sm4(Cipher.DECRYPT_MODE, decoder.decode(dataenc)))

    fun queryParams(): MultiValueMap<String, String> {
        val timeStamp = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now())
        val random = (Random.nextInt(900) + 100).toString()
        val signKey = getSignKey(timeStamp, random)
        val otherMap = mapOf(
            "PackageName" to listOf("com.hisense.wfbus2"),
            "Random" to listOf(random),
            "SignKey" to listOf(signKey),
            "timeStamp" to listOf(timeStamp),
        )
        return LinkedMultiValueMap(otherMap)
    }

    private fun getSignKey(timeStamp: String, random: String): String {
        val secretKeySpec = SecretKeySpec(APP_KEY.toByteArray(), "HmacSHA256")
        val data = (timeStamp + random).toByteArray()
        val hash = Mac.getInstance("HmacSHA256").apply { init(secretKeySpec) }.doFinal(data)
        return hash.joinToString("") { "%02x".format(it) }
    }

    fun encryptedString(param: String): String {
        val d = LocalDate.now()
        val shift = (d.dayOfMonth - d.dayOfWeek.value).let { if (it <= 10) it + 7 else it }
        return param.map { (it.code + shift).toChar() }.joinToString("")
    }

}