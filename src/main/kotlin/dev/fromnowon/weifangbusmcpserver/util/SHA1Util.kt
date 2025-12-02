package dev.fromnowon.weifangbusmcpserver.util

import java.security.MessageDigest

fun sha1(input: String): String = input.toByteArray().let { bytes ->
    MessageDigest.getInstance("SHA-1").digest(bytes).joinToString("") { "%02x".format(it) }
}