package dev.fromnowon.weifangbusmcpserver.client

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

    client.callTool(McpSchema.CallToolRequest("getOTP", null)).also { println(it) }

    val account = System.getenv("TEST_USER_PHONE")
    val password = System.getenv("TEST_USER_PASSWORD")
    client.callTool(McpSchema.CallToolRequest("login", mapOf("account" to account, "password" to password)))
        .also { println(it) }

    client.callTool(McpSchema.CallToolRequest("getAllSubRouteData", null)).also { println(it) }

    client.closeGracefully()

}