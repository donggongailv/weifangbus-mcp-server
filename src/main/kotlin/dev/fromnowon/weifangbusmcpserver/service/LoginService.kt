package dev.fromnowon.weifangbusmcpserver.service

import com.fasterxml.jackson.databind.ObjectMapper
import dev.fromnowon.weifangbusmcpserver.constant.decoder
import dev.fromnowon.weifangbusmcpserver.param.CommonRequestParam
import dev.fromnowon.weifangbusmcpserver.param.LoginRequestParam
import dev.fromnowon.weifangbusmcpserver.param.OTPRequestParam
import dev.fromnowon.weifangbusmcpserver.param.toPayload
import dev.fromnowon.weifangbusmcpserver.response.CommonResponse
import dev.fromnowon.weifangbusmcpserver.response.LoginResponse
import dev.fromnowon.weifangbusmcpserver.response.OTPResponse
import dev.fromnowon.weifangbusmcpserver.util.*
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.requiredBody
import javax.crypto.Cipher

@Service
class LoginService(
    private val commonService: CommonService,
    private val restClient: RestClient,
    private val jacksonObjectMapper: ObjectMapper
) {

    @Tool(description = "获取 OTP")
    fun getOTP(): OTPResponse {
        val dataenc = commonService.dataenc(OTPRequestParam())
        val hdataenc = commonService.hdataenc()
        val commonRequestParam = CommonRequestParam(dataenc = dataenc, hdataenc = hdataenc)

        val sign = commonService.sign(commonRequestParam.toPayload())
        commonRequestParam.sign = sign

        val response =
            restClient.post().uri("/member/query/getotp/V1").body(commonRequestParam).retrieve()
                .requiredBody<CommonResponse>()

        require(response.result == "0000") { response.resultdesc.orEmpty() }

        return response.dataenc?.let { String(sm4(Cipher.DECRYPT_MODE, decoder.decode(it))) }
            ?.let { dataStr -> jacksonObjectMapper.readValue(dataStr, OTPResponse::class.java) }
            ?: throw IllegalStateException("otp response is null.")
    }

    @Tool(description = "账号(手机号)、密码 登录")
    fun login(
        @ToolParam(description = "账号. 例如 手机号") account: String,
        @ToolParam(description = "密码") password: String,
        @ToolParam(description = "otpCode") otpCode: String,
        @ToolParam(description = "otp") otp: String
    ): LoginResponse {
        val passwordHex = sm3(password.toByteArray()).uppercase()
        val passwordByteArray = hexStringToByteArray(passwordHex)
        val otpByteArray = hexStringToByteArray(otp)
        val encryptionPasswordByteArray = encryption(otpByteArray, passwordByteArray)
        val encryptionPasswordHex = byteArrayToHexString(encryptionPasswordByteArray).uppercase()

        val loginRequestParam = LoginRequestParam(
            mobilephone = account,
            loginpasswd = encryptionPasswordHex,
            otpcode = otpCode,
            weifangpassword = md5(password)
        )

        val dataenc = commonService.dataenc(loginRequestParam)
        val hdataenc = commonService.hdataenc()

        val commonRequestParam = CommonRequestParam(dataenc = dataenc, hdataenc = hdataenc)
        val sign = commonService.sign(commonRequestParam.toPayload())
        commonRequestParam.sign = sign

        val response =
            restClient.post().uri("/member/member/loginoropen/V1").body(commonRequestParam).retrieve()
                .requiredBody<CommonResponse>()

        require(response.result == "0000") { response.resultdesc.orEmpty() }

        return response.dataenc?.let { String(sm4(Cipher.DECRYPT_MODE, decoder.decode(it))) }
            ?.let { dataStr -> jacksonObjectMapper.readValue(dataStr, LoginResponse::class.java) }
            ?: throw IllegalStateException("login response is null.")
    }

}