package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
data class RouteStatDataResponse(

    @field:Schema(nullable = true)
    @field:JsonProperty("RouteType")
    val routeType: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("IsBRT")
    val isBRT: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("IsNewData")
    val isNewData: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("BrotherRoute")
    val brotherRoute: Any? = null,

    @field:Schema(nullable = true, description = "一般是线路的两个方向")
    @field:JsonProperty("SegmentList")
    val segmentList: List<SegmentListItem?>? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RouteName")
    val routeName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RouteID")
    val routeID: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("TimeStamp")
    val timeStamp: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RouteMemo")
    val routeMemo: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Ismainsub")
    val ismainsub: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SegmentListItem(

    @field:Schema(nullable = true)
    @field:JsonProperty("Baidumapid")
    val baidumapid: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("FirstTime")
    val firstTime: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("PeakTimeSpan")
    val peakTimeSpan: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("SegmentName")
    val segmentName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RoutePrice")
    val routePrice: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("SegmentID")
    val segmentID: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("NormalTimeSpan")
    val normalTimeSpan: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("FirtLastShiftInfo2")
    val firtLastShiftInfo2: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Amapid")
    val amapid: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("DrawType")
    val drawType: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("FirtLastShiftInfo")
    val firtLastShiftInfo: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Memos")
    val memos: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("RunDirection")
    val runDirection: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationList")
    val stationList: List<StationListItem?>? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("LastTime")
    val lastTime: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StationListItem(

    @field:Schema(nullable = true)
    @field:JsonProperty("StationName")
    val stationName: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Speed")
    val speed: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("DualSerial")
    val dualSerial: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Stationmemo")
    val stationmemo: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationSort")
    val stationSort: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationSectionList")
    val stationSectionList: List<StationSectionListItem?>? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationNO")
    val stationNO: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationPostion")
    val stationPostion: StationPostion? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Sngserialid")
    val sngserialid: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationID")
    val stationID: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class StationSectionListItem(

    @field:Schema(nullable = true)
    @field:JsonProperty("SectionPostion")
    val sectionPostion: SectionPostion? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Speed")
    val speed: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("DegreeOfCongestion")
    val degreeOfCongestion: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("StationID")
    val stationID: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SectionPostion(

    @field:Schema(nullable = true)
    @field:JsonProperty("Latitude")
    val latitude: Any? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Longitude")
    val longitude: Any? = null
)
