package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AllSubRouteResponse(

    @field:JsonProperty("IsNewData")
    val isNewData: String? = null,

    @field:JsonProperty("RouteList")
    val routeList: List<RouteListItem>? = null,

    @field:JsonProperty("TimeStamp")
    val timeStamp: String? = null
)

data class RouteListItem(

    @field:JsonProperty("RouteNameExt")
    val routeNameExt: Any? = null,

    @field:JsonProperty("RouteName")
    val routeName: String? = null,

    @field:JsonProperty("RouteID")
    val routeID: Int? = null,

    @field:JsonProperty("IsHaveSubRouteCombine")
    val isHaveSubRouteCombine: String? = null,

    @field:JsonProperty("Sortinfo")
    val sortInfo: Int? = null
)
