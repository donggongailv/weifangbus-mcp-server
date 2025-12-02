package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LoginResponse(

    @field:JsonProperty("memberno")
    val memberno: String? = null,

    @field:JsonProperty("nickname")
    val nickname: String? = null,

    @field:JsonProperty("servicelist")
    val servicelist: List<ServicelistItem?>? = null,

    @field:JsonProperty("iffirstreg")
    val iffirstreg: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ServicelistItem(

    @field:JsonProperty("serviceifopen")
    val serviceifopen: String? = null,

    @field:JsonProperty("servicetype")
    val servicetype: String? = null,

    @field:JsonProperty("serviceopentime")
    val serviceopentime: String? = null,

    @field:JsonProperty("serviceid")
    val serviceid: String? = null,

    @field:JsonProperty("serviceopendate")
    val serviceopendate: String? = null
)
