package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription

@JsonIgnoreProperties(ignoreUnknown = true)
data class AllSubRouteResponse(

    @field:JsonProperty("IsNewData")
    val isNewData: String? = null,

    @field:JsonPropertyDescription("线路列表")
    @field:JsonProperty("RouteList")
    val routeList: List<RouteListItem>? = null,

    @field:JsonProperty("TimeStamp")
    val timeStamp: String? = null
)

data class RouteListItem(

    @field:JsonProperty("RouteNameExt")
    val routeNameExt: Any? = null,

    @field:JsonPropertyDescription("线路名称")
    @field:JsonProperty("RouteName")
    val routeName: String? = null,

    @field:JsonPropertyDescription("线路id")
    @field:JsonProperty("RouteID")
    val routeID: Int? = null,

    @field:JsonProperty("IsHaveSubRouteCombine")
    val isHaveSubRouteCombine: String? = null,

    @field:JsonProperty("Sortinfo")
    val sortInfo: Int? = null
)
