package dev.fromnowon.weifangbusmcpserver

import dev.fromnowon.weifangbusmcpserver.service.LoginService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WeifangbusMcpServerApplicationTests() {

    @Autowired
    private lateinit var loginService: LoginService

    @Test
    fun login(@Value($$"${TEST_USER_PHONE}") account: String, @Value($$"${TEST_USER_PASSWORD}") password: String) {
        loginService.login(account, password).also { println(it) }
    }

}
