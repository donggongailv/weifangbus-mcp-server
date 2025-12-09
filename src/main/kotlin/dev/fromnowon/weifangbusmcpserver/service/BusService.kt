package dev.fromnowon.weifangbusmcpserver.service

import dev.fromnowon.weifangbusmcpserver.response.AllSubRouteResponse
import dev.fromnowon.weifangbusmcpserver.response.NearByStatInfoResponse
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.requiredBody

@Service
class BusService(private val busRestClient: RestClient, private val commonService: CommonService) {

    @Tool(description = "获取所有的线路数据")
    fun getAllSubRouteData(): AllSubRouteResponse = busRestClient.get()
        .uri { it.path("/BusService/Query_AllSubRouteData/").queryParams(commonService.queryParams()).build() }
        .retrieve().requiredBody<AllSubRouteResponse>()

    @Tool(description = "获取附近站点")
    fun getNearbyStatInfo(
        @ToolParam(description = "经度") longitude: Double,
        @ToolParam(description = "维度") latitude: Double
    ): List<NearByStatInfoResponse> {
        return busRestClient.get().uri {
            it.path("/BusService/Query_NearbyStatInfo/")
                .queryParams(commonService.queryParams())
                .queryParam("Latitude", latitude)
                .queryParam("Longitude", longitude)
                .queryParam("Range", 1000)
                .build()
        }.retrieve().requiredBody<List<NearByStatInfoResponse>>()
    }

}