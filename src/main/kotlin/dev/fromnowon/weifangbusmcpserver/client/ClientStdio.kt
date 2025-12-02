package dev.fromnowon.weifangbusmcpserver.client

import com.fasterxml.jackson.databind.ObjectMapper
import dev.fromnowon.weifangbusmcpserver.response.OTPResponse
import io.modelcontextprotocol.client.McpClient
import io.modelcontextprotocol.client.transport.ServerParameters
import io.modelcontextprotocol.client.transport.StdioClientTransport
import io.modelcontextprotocol.json.McpJsonMapper
import io.modelcontextprotocol.spec.McpSchema

fun main() {

    val stdioParams =
        ServerParameters.builder("java").args("-jar", "build/libs/weifangbus-mcp-server-0.0.1-SNAPSHOT.jar").build()

    val transport = StdioClientTransport(stdioParams, McpJsonMapper.createDefault())
    val client = McpClient.sync(transport).build().apply { initialize() }

    client.listTools().also { println(it) }

    val toolResult = client.callTool(McpSchema.CallToolRequest("getOTP", null)).also { println(it) }

    val otpResponseStr = (toolResult.content.firstOrNull() as McpSchema.TextContent).text
    val (otpcode, otp) = ObjectMapper().readValue(otpResponseStr, OTPResponse::class.java)

    client.callTool(
        McpSchema.CallToolRequest(
            "login",
            mapOf("account" to "你的手机号", "password" to "你的密码", "otpCode" to otpcode, "otp" to otp)
        )
    ).also { println(it) }

    client.closeGracefully()

}