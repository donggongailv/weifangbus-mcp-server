package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class OTPResponse(

    @field:JsonProperty("otpcode")
    val otpcode: String? = null,

    @field:JsonProperty("otp")
    val otp: String? = null
)
