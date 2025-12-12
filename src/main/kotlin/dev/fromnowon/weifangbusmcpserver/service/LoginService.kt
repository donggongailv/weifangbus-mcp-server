package dev.fromnowon.weifangbusmcpserver.service

import com.fasterxml.jackson.databind.ObjectMapper
import dev.fromnowon.weifangbusmcpserver.param.CommonRequestParam
import dev.fromnowon.weifangbusmcpserver.param.LoginRequestParam
import dev.fromnowon.weifangbusmcpserver.param.OTPRequestParam
import dev.fromnowon.weifangbusmcpserver.param.toPayload
import dev.fromnowon.weifangbusmcpserver.response.CommonResponse
import dev.fromnowon.weifangbusmcpserver.response.LoginResponse
import dev.fromnowon.weifangbusmcpserver.response.OTPResponse
import dev.fromnowon.weifangbusmcpserver.util.*
import org.springaicommunity.mcp.annotation.McpTool
import org.springaicommunity.mcp.annotation.McpToolParam
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.requiredBody

@Service
class LoginService(
    private val commonService: CommonService,
    private val restClient: RestClient,
    private val jacksonObjectMapper: ObjectMapper
) {

    @McpTool(description = "获取 OTP", generateOutputSchema = true)
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

        return response.dataenc?.let { commonService.decrypt(it) }
            ?.let { jacksonObjectMapper.readValue(it, OTPResponse::class.java) }
            ?: throw IllegalStateException("otp response is null.")
    }

    @McpTool(description = "账号(手机号)、密码 登录", generateOutputSchema = true)
    fun login(
        @McpToolParam(description = "账号. 例如 手机号") account: String,
        @McpToolParam(description = "密码") password: String
    ): LoginResponse {
        val (otpCode, otp) = getOTP()

        val passwordHex = sm3(password.toByteArray()).uppercase()
        val passwordByteArray = hexStringToByteArray(passwordHex)
        val otpByteArray = hexStringToByteArray(checkNotNull(otp))
        val encryptionPasswordByteArray = encryption(otpByteArray, passwordByteArray)
        val encryptionPasswordHex = byteArrayToHexString(encryptionPasswordByteArray).uppercase()

        val loginRequestParam = LoginRequestParam(
            mobilephone = account,
            loginpasswd = encryptionPasswordHex,
            otpcode = checkNotNull(otpCode),
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

        return response.dataenc?.let { commonService.decrypt(it) }
            ?.let { jacksonObjectMapper.readValue(it, LoginResponse::class.java) }
            ?: throw IllegalStateException("login response is null.")
    }

}