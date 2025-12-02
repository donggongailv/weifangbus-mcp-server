package dev.fromnowon.weifangbusmcpserver.param

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import dev.fromnowon.weifangbusmcpserver.util.dateTimeAndRandomDigitsStr
import dev.fromnowon.weifangbusmcpserver.util.dateTimeStr
import dev.fromnowon.weifangbusmcpserver.util.sha1

@JsonIgnoreProperties(ignoreUnknown = true)
data class CommonRequestParam(

    val joininstid: String = "00000001",

    val joininstssn: String = dateTimeAndRandomDigitsStr(4),

    val reqdate: String = dateTimeStr("yyyyMMdd"),

    val reqtime: String = dateTimeStr("HHmmss"),

    val dataenc: String,

    val hdataenc: String

) {

    var sign: String? = null

}

fun CommonRequestParam.toPayload(): String = sha1(buildString {
    append("dataenc").append(dataenc)
    append("hdataenc").append(hdataenc)
    append("joininstid").append(joininstid)
    append("joininstssn").append(joininstssn)
    append("reqdate").append(reqdate)
    append("reqtime").append(reqtime)
})
