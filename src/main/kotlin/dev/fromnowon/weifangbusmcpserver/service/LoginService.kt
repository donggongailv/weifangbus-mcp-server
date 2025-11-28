package dev.fromnowon.weifangbusmcpserver.service

import com.fasterxml.jackson.databind.ObjectMapper
import dev.fromnowon.weifangbusmcpserver.constant.decoder
import dev.fromnowon.weifangbusmcpserver.param.CommonRequestParam
import dev.fromnowon.weifangbusmcpserver.param.OTPRequestParam
import dev.fromnowon.weifangbusmcpserver.param.payload
import dev.fromnowon.weifangbusmcpserver.response.OTPData
import dev.fromnowon.weifangbusmcpserver.response.OTPResponse
import dev.fromnowon.weifangbusmcpserver.util.sm4
import org.springframework.ai.tool.annotation.Tool
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import javax.crypto.Cipher

@Service
class LoginService(
    private val commonService: CommonService,
    private val restClient: RestClient,
    private val jacksonObjectMapper: ObjectMapper
) {

    @Tool(description = "获取 OTP")
    fun getOTP(): OTPData {
        val dataenc = commonService.dataenc(OTPRequestParam())
        val hdataenc = commonService.hdataenc()
        val commonRequestParam = CommonRequestParam(dataenc = dataenc, hdataenc = hdataenc)
        val sign = commonService.sign(commonRequestParam.payload())
        commonRequestParam.sign = sign

        val response =
            restClient.post().uri("/member/query/getotp/V1").body(commonRequestParam).retrieve().body<OTPResponse>()

        val dataStr = response?.dataenc?.let { String(sm4(Cipher.DECRYPT_MODE, decoder.decode(it))) }

        return jacksonObjectMapper.readValue(dataStr, OTPData::class.java)
            ?: throw IllegalStateException("获取 otp 异常!")
    }

}