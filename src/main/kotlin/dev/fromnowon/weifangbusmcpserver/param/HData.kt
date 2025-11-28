package dev.fromnowon.weifangbusmcpserver.param

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import dev.fromnowon.weifangbusmcpserver.constant.MCHNTID

@JsonIgnoreProperties(ignoreUnknown = true)
data class HData(

    val instid: String = "00000001",

    val chnlid: String = "00",

    val mchntid: String = MCHNTID

)
