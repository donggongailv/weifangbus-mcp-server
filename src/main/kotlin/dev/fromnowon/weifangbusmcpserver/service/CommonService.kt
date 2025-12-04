package dev.fromnowon.weifangbusmcpserver.service

import ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray
import com.fasterxml.jackson.databind.ObjectMapper
import dev.fromnowon.weifangbusmcpserver.constant.decoder
import dev.fromnowon.weifangbusmcpserver.constant.encoder
import dev.fromnowon.weifangbusmcpserver.param.HData
import dev.fromnowon.weifangbusmcpserver.util.signature
import dev.fromnowon.weifangbusmcpserver.util.sm4
import org.springframework.stereotype.Service
import javax.crypto.Cipher

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

}