package dev.fromnowon.weifangbusmcpserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

    @Bean
    fun restClient(): RestClient = RestClient.builder().baseUrl("https://mobile.wfsmk.cn:3000").build()

    @Bean
    fun busRestClient(): RestClient {
        val jacksonConverter = MappingJackson2HttpMessageConverter().apply {
            supportedMediaTypes = listOf(
                MediaType("text", "json"),
                MediaType.APPLICATION_JSON,
            )
        }

        return RestClient.builder().messageConverters { it.add(0, jacksonConverter) }
            .baseUrl("http://122.4.254.30:8088").build()
    }

}