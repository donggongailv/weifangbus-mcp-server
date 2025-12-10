package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class RouteStatDataResponse(

    @field:JsonProperty("RouteType")
    val routeType: String? = null,

    @field:JsonProperty("IsBRT")
    val isBRT: String? = null,

    @field:JsonProperty("IsNewData")
    val isNewData: String? = null,

    @field:JsonProperty("BrotherRoute")
    val brotherRoute: Any? = null,

    @field:JsonProperty("SegmentList")
    val segmentList: List<SegmentListItem?>? = null,

    @field:JsonProperty("RouteName")
    val routeName: String? = null,

    @field:JsonProperty("RouteID")
    val routeID: Int? = null,

    @field:JsonProperty("TimeStamp")
    val timeStamp: String? = null,

    @field:JsonProperty("RouteMemo")
    val routeMemo: Any? = null,

    @field:JsonProperty("Ismainsub")
    val ismainsub: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SegmentListItem(

    @field:JsonProperty("Baidumapid")
    val baidumapid: Any? = null,

    @field:JsonProperty("FirstTime")
    val firstTime: String? = null,

    @field:JsonProperty("PeakTimeSpan")
    val peakTimeSpan: Any? = null,

    @field:JsonProperty("SegmentName")
    val segmentName: String? = null,

    @field:JsonProperty("RoutePrice")
    val routePrice: String? = null,

    @field:JsonProperty("SegmentID")
    val segmentID: Int? = null,

    @field:JsonProperty("NormalTimeSpan")
    val normalTimeSpan: Int? = null,

    @field:JsonProperty("FirtLastShiftInfo2")
    val firtLastShiftInfo2: Any? = null,

    @field:JsonProperty("Amapid")
    val amapid: Any? = null,

    @field:JsonProperty("DrawType")
    val drawType: String? = null,

    @field:JsonProperty("FirtLastShiftInfo")
    val firtLastShiftInfo: String? = null,

    @field:JsonProperty("Memos")
    val memos: Any? = null,

    @field:JsonProperty("RunDirection")
    val runDirection: String? = null,

    @field:JsonProperty("StationList")
    val stationList: List<StationListItem?>? = null,

    @field:JsonProperty("LastTime")
    val lastTime: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StationListItem(

    @field:JsonProperty("StationName")
    val stationName: String? = null,

    @field:JsonProperty("Speed")
    val speed: Any? = null,

    @field:JsonProperty("DualSerial")
    val dualSerial: Int? = null,

    @field:JsonProperty("Stationmemo")
    val stationmemo: Any? = null,

    @field:JsonProperty("StationSort")
    val stationSort: Int? = null,

    @field:JsonProperty("StationSectionList")
    val stationSectionList: List<StationSectionListItem?>? = null,

    @field:JsonProperty("StationNO")
    val stationNO: String? = null,

    @field:JsonProperty("StationPostion")
    val stationPostion: StationPostion? = null,

    @field:JsonProperty("Sngserialid")
    val sngserialid: Int? = null,

    @field:JsonProperty("StationID")
    val stationID: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StationSectionListItem(

    @field:JsonProperty("SectionPostion")
    val sectionPostion: SectionPostion? = null,

    @field:JsonProperty("Speed")
    val speed: String? = null,

    @field:JsonProperty("DegreeOfCongestion")
    val degreeOfCongestion: String? = null,

    @field:JsonProperty("StationID")
    val stationID: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SectionPostion(

    @field:JsonProperty("Latitude")
    val latitude: Any? = null,

    @field:JsonProperty("Longitude")
    val longitude: Any? = null
)
