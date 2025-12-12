package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import io.swagger.v3.oas.annotations.media.Schema

@JsonIgnoreProperties(ignoreUnknown = true)
data class AllSubRouteResponse(

    @field:Schema(nullable = true)
    @field:JsonProperty("IsNewData")
    val isNewData: String? = null,

    @field:JsonPropertyDescription("线路列表")
    @field:Schema(nullable = true)
    @field:JsonProperty("RouteList")
    val routeList: List<RouteListItem>? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("TimeStamp")
    val timeStamp: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class RouteListItem(

    @field:Schema(nullable = true)
    @field:JsonProperty("RouteNameExt")
    val routeNameExt: Any? = null,

    @field:JsonPropertyDescription("线路名称")
    @field:Schema(nullable = true)
    @field:JsonProperty("RouteName")
    val routeName: String? = null,

    @field:JsonPropertyDescription("线路id")
    @field:Schema(nullable = true)
    @field:JsonProperty("RouteID")
    val routeID: Int? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("IsHaveSubRouteCombine")
    val isHaveSubRouteCombine: String? = null,

    @field:Schema(nullable = true)
    @field:JsonProperty("Sortinfo")
    val sortInfo: Int? = null
)
