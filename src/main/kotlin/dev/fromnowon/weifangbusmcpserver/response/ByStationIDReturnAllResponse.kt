package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
data class ByStationIDReturnAllResponse(

    @field:Schema(nullable = true)
    @field:JsonProperty("Sortinfo2")
    val sortinfo2: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("FirstTime")
    val firstTime: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("FirtLastShiftInfo2")
    val firtLastShiftInfo2: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RealtimeInfoList")
    val realtimeInfoList: List<RealtimeInfoListItem?>? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("EndStaInfo")
    val endStaInfo: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RouteID")
    val routeID: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("MainSubRouteID")
    val mainSubRouteID: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("ServerTime")
    val serverTime: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationID")
    val stationID: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationName")
    val stationName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("FirtLastShiftInfo")
    val firtLastShiftInfo: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RouteName")
    val routeName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Sortinfo")
    val sortinfo: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("LastTime")
    val lastTime: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("DepartureState")
    val departureState: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RealtimeInfoListItem(

    @field:Schema(nullable = true)
    @field:JsonProperty("GPSTime")
    val gPSTime: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("SendTime")
    val sendTime: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("ArriveTime")
    val arriveTime: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Temperature")
    val temperature: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("BusID")
    val busID: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("SpaceNum")
    val spaceNum: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RunTime")
    val runTime: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("SortTime")
    val sortTime: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("ISLast")
    val iSLast: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Areaconglevel")
    val areaconglevel: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Productid")
    val productid: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("BusPostion")
    val busPostion: BusPostion? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationID")
    val stationID: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("BusName")
    val busName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("ForeCastInfo2")
    val foreCastInfo2: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("ForeCastInfo1")
    val foreCastInfo1: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("LeaveOrStop")
    val leaveOrStop: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("islovebus")
    val islovebus: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("ArriveStaName")
    val arriveStaName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("SubRouteID")
    val subRouteID: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Distance")
    val distance: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("DepartureState")
    val departureState: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class BusPostion(

    @field:Schema(nullable = true)
    @field:JsonProperty("Latitude")
    val latitude: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Longitude")
    val longitude: Any? = null
)
