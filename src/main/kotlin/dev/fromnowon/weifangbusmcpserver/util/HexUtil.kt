package dev.fromnowon.weifangbusmcpserver.util

import org.bouncycastle.util.encoders.Hex

/**
 * 将字节数组转为十六进制字符串
 */
fun byteArrayToHexString(byteArray: ByteArray): String = Hex.toHexString(byteArray)

/**
 * 将十六进制字符串转为字节数组
 */
fun hexStringToByteArray(str: String): ByteArray = Hex.decodeStrict(str)