package dev.fromnowon.weifangbusmcpserver.service

import dev.fromnowon.weifangbusmcpserver.response.AllSubRouteResponse
import org.springframework.ai.tool.annotation.Tool
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.requiredBody

@Service
class BusService(private val busRestClient: RestClient, private val commonService: CommonService) {

    @Tool(description = "获取所有的线路数据")
    fun getAllSubRouteData(): AllSubRouteResponse = busRestClient.get()
        .uri { it.path("/BusService/Query_AllSubRouteData/").queryParams(commonService.queryParams()).build() }
        .retrieve().requiredBody<AllSubRouteResponse>()

}