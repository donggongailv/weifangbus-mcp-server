package dev.fromnowon.weifangbusmcpserver.config

import dev.fromnowon.weifangbusmcpserver.service.BusService
import dev.fromnowon.weifangbusmcpserver.service.LoginService
import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.ai.tool.method.MethodToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ToolConfig {

    @Bean
    fun weifangBusTools(loginService: LoginService, busService: BusService): ToolCallbackProvider =
        MethodToolCallbackProvider.builder().toolObjects(loginService, busService).build()

}