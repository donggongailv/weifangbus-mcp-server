package dev.fromnowon.weifangbusmcpserver.util

import ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray
import dev.fromnowon.weifangbusmcpserver.constant.SERVER_DG_KEY
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

private val publicKeyByteArray by lazy { hexStringToByteArray(SERVER_DG_KEY) }

const val algorithm = "SM4"

private val secretKey by lazy { SecretKeySpec(publicKeyByteArray, algorithm) }

private val cipher by lazy {
    Security.getProvider(BouncyCastleProvider.PROVIDER_NAME).let {
        Cipher.getInstance(algorithm, it)
    }
}

fun sm4(opmode: Int, dataByteArray: ByteArray): ByteArray =
    cipher.init(opmode, secretKey).run { cipher.doFinal(dataByteArray) }