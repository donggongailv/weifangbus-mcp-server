package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
data class LoginResponse(

    @field:Schema(nullable = true)
    @field:JsonProperty("memberno")
    val memberno: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("nickname")
    val nickname: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("servicelist")
    val servicelist: List<ServicelistItem?>? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("iffirstreg")
    val iffirstreg: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ServicelistItem(

    @field:Schema(nullable = true)
    @field:JsonProperty("serviceifopen")
    val serviceifopen: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("servicetype")
    val servicetype: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("serviceopentime")
    val serviceopentime: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("serviceid")
    val serviceid: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("serviceopendate")
    val serviceopendate: String? = null
)
