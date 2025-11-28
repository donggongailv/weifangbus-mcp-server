package dev.fromnowon.weifangbusmcpserver

import dev.fromnowon.weifangbusmcpserver.service.LoginService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WeifangbusMcpServerApplicationTests() {

    @Autowired
    private lateinit var loginService: LoginService

    @Test
    fun getOTP() {
        loginService.getOTP().also { println(it) }
    }

}
