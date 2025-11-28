package dev.fromnowon.weifangbusmcpserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

    @Bean
    fun restClient(): RestClient = RestClient.builder().baseUrl("https://mobile.wfsmk.cn:3000").build()

}