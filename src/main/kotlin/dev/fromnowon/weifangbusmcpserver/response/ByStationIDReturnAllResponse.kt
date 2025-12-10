package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ByStationIDReturnAllResponse(

    @field:JsonProperty("Sortinfo2")
    val sortinfo2: Int? = null,

    @field:JsonProperty("FirstTime")
    val firstTime: String? = null,

    @field:JsonProperty("FirtLastShiftInfo2")
    val firtLastShiftInfo2: Any? = null,

    @field:JsonProperty("RealtimeInfoList")
    val realtimeInfoList: List<RealtimeInfoListItem?>? = null,

    @field:JsonProperty("EndStaInfo")
    val endStaInfo: String? = null,

    @field:JsonProperty("RouteID")
    val routeID: Int? = null,

    @field:JsonProperty("MainSubRouteID")
    val mainSubRouteID: Any? = null,

    @field:JsonProperty("ServerTime")
    val serverTime: String? = null,

    @field:JsonProperty("StationID")
    val stationID: String? = null,

    @field:JsonProperty("StationName")
    val stationName: String? = null,

    @field:JsonProperty("FirtLastShiftInfo")
    val firtLastShiftInfo: String? = null,

    @field:JsonProperty("RouteName")
    val routeName: String? = null,

    @field:JsonProperty("Sortinfo")
    val sortinfo: Int? = null,

    @field:JsonProperty("LastTime")
    val lastTime: String? = null,

    @field:JsonProperty("DepartureState")
    val departureState: String? = null
)

data class RealtimeInfoListItem(

    @field:JsonProperty("GPSTime")
    val gPSTime: String? = null,

    @field:JsonProperty("SendTime")
    val sendTime: Any? = null,

    @field:JsonProperty("ArriveTime")
    val arriveTime: String? = null,

    @field:JsonProperty("Temperature")
    val temperature: String? = null,

    @field:JsonProperty("BusID")
    val busID: String? = null,

    @field:JsonProperty("SpaceNum")
    val spaceNum: Int? = null,

    @field:JsonProperty("RunTime")
    val runTime: Int? = null,

    @field:JsonProperty("SortTime")
    val sortTime: Any? = null,

    @field:JsonProperty("ISLast")
    val iSLast: Int? = null,

    @field:JsonProperty("Areaconglevel")
    val areaconglevel: String? = null,

    @field:JsonProperty("Productid")
    val productid: Int? = null,

    @field:JsonProperty("BusPostion")
    val busPostion: BusPostion? = null,

    @field:JsonProperty("StationID")
    val stationID: String? = null,

    @field:JsonProperty("BusName")
    val busName: String? = null,

    @field:JsonProperty("ForeCastInfo2")
    val foreCastInfo2: String? = null,

    @field:JsonProperty("ForeCastInfo1")
    val foreCastInfo1: String? = null,

    @field:JsonProperty("LeaveOrStop")
    val leaveOrStop: Int? = null,

    @field:JsonProperty("islovebus")
    val islovebus: Any? = null,

    @field:JsonProperty("ArriveStaName")
    val arriveStaName: String? = null,

    @field:JsonProperty("SubRouteID")
    val subRouteID: Int? = null,

    @field:JsonProperty("Distance")
    val distance: String? = null,

    @field:JsonProperty("DepartureState")
    val departureState: String? = null
)

data class BusPostion(

    @field:JsonProperty("Latitude")
    val latitude: Any? = null,

    @field:JsonProperty("Longitude")
    val longitude: Any? = null
)
