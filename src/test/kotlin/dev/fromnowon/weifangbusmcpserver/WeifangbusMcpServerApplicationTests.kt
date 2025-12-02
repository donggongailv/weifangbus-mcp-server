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
    fun login() {
        val otpResponse = loginService.getOTP().also { println(it) }
        loginService.login(
            "你的手机号",
            "你的密码",
            checkNotNull(otpResponse.otpcode),
            checkNotNull(otpResponse.otp)
        ).also { println(it) }
    }

}
