package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
data class OTPResponse(

    @field:Schema(nullable = true)
    @field:JsonProperty("otpcode")
    val otpcode: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("otp")
    val otp: String? = null
)
