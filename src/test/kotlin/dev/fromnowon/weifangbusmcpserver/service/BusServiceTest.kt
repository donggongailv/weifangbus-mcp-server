package dev.fromnowon.weifangbusmcpserver.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BusServiceTest() {
    @Test
    fun getRouteStatData() {
        busService.getRouteStatData(17).also { println(it) }
    }

    @Autowired
    private lateinit var busService: BusService

    @Test
    fun getAllSubRouteData() {
        busService.getAllSubRouteData().also { println(it) }
    }

    @Test
    fun getNearbyStatInfo() {
        busService.getNearbyStatInfo(119.138744, 36.709315).also { println(it) }
    }

}