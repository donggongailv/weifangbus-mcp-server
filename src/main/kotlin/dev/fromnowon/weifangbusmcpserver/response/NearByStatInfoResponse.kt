package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class NearByStatInfoResponse(

    @field:JsonProperty("StationMemo")
    val stationMemo: Any? = null,

    @field:JsonProperty("StationName")
    val stationName: String? = null,

    @field:JsonProperty("IsMainSta")
    val isMainSta: Any? = null,

    @field:JsonProperty("StationPostion")
    val stationPostion: StationPostion? = null,

    @field:JsonProperty("StationID")
    val stationID: String? = null,

    @field:JsonProperty("Distance")
    val distance: Any? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StationPostion(

    @field:JsonProperty("Latitude")
    val latitude: Any? = null,

    @field:JsonProperty("Longitude")
    val longitude: Any? = null
)
