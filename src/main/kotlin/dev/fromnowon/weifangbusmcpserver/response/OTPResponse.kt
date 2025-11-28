package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class OTPResponse(

    @field:JsonProperty("result")
    val result: String? = null,

    @field:JsonProperty("data")
    val data: Any? = null,

    @field:JsonProperty("dataenc")
    val dataenc: String? = null,

    @field:JsonProperty("resultdesc")
    val resultdesc: String? = null
)
