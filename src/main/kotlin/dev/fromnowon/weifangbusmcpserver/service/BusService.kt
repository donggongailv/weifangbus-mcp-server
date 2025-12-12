package dev.fromnowon.weifangbusmcpserver.service

import dev.fromnowon.weifangbusmcpserver.response.AllSubRouteResponse
import dev.fromnowon.weifangbusmcpserver.response.ByStationIDReturnAllResponse
import dev.fromnowon.weifangbusmcpserver.response.NearByStatInfoResponse
import dev.fromnowon.weifangbusmcpserver.response.RouteStatDataResponse
import org.springaicommunity.mcp.annotation.McpTool
import org.springaicommunity.mcp.annotation.McpToolParam
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.requiredBody

@Service
class BusService(private val busRestClient: RestClient, private val commonService: CommonService) {

    @McpTool(description = "获取所有的线路数据", generateOutputSchema = true)
    fun getAllSubRouteData(): AllSubRouteResponse = busRestClient.get()
        .uri { it.path("/BusService/Query_AllSubRouteData/").queryParams(commonService.queryParams()).build() }
        .retrieve().requiredBody<AllSubRouteResponse>()

    @McpTool(description = "获取附近站点", generateOutputSchema = true)
    fun getNearbyStatInfo(
        @McpToolParam(description = "经度") longitude: Double,
        @McpToolParam(description = "维度") latitude: Double
    ): List<NearByStatInfoResponse> = busRestClient.get().uri {
        it.path("/BusService/Query_NearbyStatInfo/")
            .queryParams(commonService.queryParams())
            .queryParam("Latitude", latitude)
            .queryParam("Longitude", longitude)
            .queryParam("Range", 1000)
            .build()
    }.retrieve().requiredBody<List<NearByStatInfoResponse>>()

    @McpTool(description = "获取线路状态数据(线路详情)", generateOutputSchema = true)
    fun getRouteStatData(@McpToolParam(description = "线路id") routeId: Int): List<RouteStatDataResponse> =
        busRestClient.get().uri {
            it.path("/BusService/Query_RouteStatData/").queryParams(commonService.queryParams())
                .queryParam("RouteID", commonService.encryptedString(routeId.toString()))
                .build()
        }.retrieve().requiredBody<List<RouteStatDataResponse>>()

    @McpTool(description = "获取站点信息和相应的车辆信息", generateOutputSchema = true)
    fun getByStationIDReturnAll(
        @McpToolParam(description = "线路id") routeId: Int,
        @McpToolParam(description = "站点id") stationId: String
    ): List<ByStationIDReturnAllResponse> = busRestClient.get().uri {
        it.path("/BusService/Query_ByStationIDReturnAll/").queryParams(commonService.queryParams())
            .queryParam("RouteID", commonService.encryptedString(routeId.toString()))
            .queryParam("StationID", commonService.encryptedString(stationId))
            .build()
    }.retrieve().requiredBody<List<ByStationIDReturnAllResponse>>()

}