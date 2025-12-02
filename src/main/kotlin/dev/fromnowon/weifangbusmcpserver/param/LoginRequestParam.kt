package dev.fromnowon.weifangbusmcpserver.param

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class LoginRequestParam(

    val logintype: String = "00",

    val operationsence: String = "01",

    val deviceno: String = UUID.randomUUID().toString(),

    val mobilephone: String,

    val loginpasswd: String,

    val otpcode: String,

    val weifangpassword: String

)
