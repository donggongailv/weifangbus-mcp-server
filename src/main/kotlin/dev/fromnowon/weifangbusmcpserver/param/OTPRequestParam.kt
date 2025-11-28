package dev.fromnowon.weifangbusmcpserver.param

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class OTPRequestParam(

    @field:JsonProperty(value = "otptype")
    val otpType: String = "01"

)
