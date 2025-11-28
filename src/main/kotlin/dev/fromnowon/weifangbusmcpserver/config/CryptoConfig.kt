package dev.fromnowon.weifangbusmcpserver.config

import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.springframework.context.annotation.Configuration
import jakarta.annotation.PostConstruct
import java.security.Security

@Configuration
class CryptoConfig {

    @PostConstruct
    fun init() {
        Security.addProvider(BouncyCastleProvider())
    }

}
