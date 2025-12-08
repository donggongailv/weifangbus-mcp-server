package dev.fromnowon.weifangbusmcpserver.constant

import java.util.*

const val APP_KEY = "adf0d9607ab24a3d88a5fb5413813e2a";

const val SERVER_PRIVATE_KEY: String = "defde0564c31e6733fd836f135c1b6c0d8dcaa4d95be93fde403b3415459bf5d"

const val SERVER_DG_KEY: String = "12345698765432101234569876543210"

const val MCHNTID: String = "000000010001"

val encoder: Base64.Encoder by lazy { Base64.getEncoder() }

val decoder: Base64.Decoder by lazy { Base64.getDecoder() }