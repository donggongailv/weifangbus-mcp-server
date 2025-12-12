package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
data class NearByStatInfoResponse(

    @field:Schema(nullable = true)
    @field:JsonProperty("StationMemo")
    val stationMemo: Any? = null,

    @field:Schema(nullable = true, description = "站点名称")
    @field:JsonProperty("StationName")
    val stationName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("IsMainSta")
    val isMainSta: Any? = null,

    @field:Schema(nullable = true, description = "站点位置")
    @field:JsonProperty("StationPostion")
    val stationPostion: StationPostion? = null,

    @field:Schema(nullable = true, description = "站点id")
    @field:JsonProperty("StationID")
    val stationID: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Distance")
    val distance: Any? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StationPostion(

    @field:Schema(nullable = true, description = "维度")
    @field:JsonProperty("Latitude")
    val latitude: Any? = null,

    @field:Schema(nullable = true, description = "经度")
    @field:JsonProperty("Longitude")
    val longitude: Any? = null
)
