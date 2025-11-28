package dev.fromnowon.weifangbusmcpserver.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

fun dateTimeAndRandomDigitsStr(count: Int): String {
    val dateTimeStr = dateTimeStr("yyyyMMddHHmmssSSS")
    val randomDigits = buildString { repeat(count) { append(Random.nextInt(9)) } }
    return "$dateTimeStr$randomDigits"
}

fun dateTimeStr(pattern: String): String = DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.now())