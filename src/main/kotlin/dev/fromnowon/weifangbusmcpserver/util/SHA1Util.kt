package dev.fromnowon.weifangbusmcpserver.util

import java.security.MessageDigest

private val messageDigest by lazy { MessageDigest.getInstance("SHA-1") }

fun sha1(input: String): String = input.toByteArray().let { bytes ->
    messageDigest.digest(bytes).joinToString("") { "%02x".format(it) }
}