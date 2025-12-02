package dev.fromnowon.weifangbusmcpserver.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class CommonResponse(

    /**
     * 响应码. 例如: 0000/正常 其他应该为异常
     */
    @field:JsonProperty("result")
    val result: String? = null,

    /**
     * 结果描述. 例如: 登录密码不正确
     */
    @field:JsonProperty("resultdesc")
    val resultdesc: String? = null,

    /**
     * 响应内容(加密)
     */
    @field:JsonProperty("dataenc")
    val dataenc: String? = null

)
