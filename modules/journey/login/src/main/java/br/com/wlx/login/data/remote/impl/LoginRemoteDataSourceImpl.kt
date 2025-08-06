package br.com.wlx.login.data.remote.impl

import br.com.wlx.communication.api.CommunicationClient
import br.com.wlx.communication.api.model.HttpMethod
import br.com.wlx.communication.api.request.BaseHttpRequest
import br.com.wlx.communication.api.request.HttpJsonRequest
import br.com.wlx.communication.api.response.BaseHttpResponse
import br.com.wlx.communication.api.util.toJsonObject
import br.com.wlx.logger.api.Logger
import br.com.wlx.login.data.remote.LoginRemoteDataSource
import br.com.wlx.login.data.remote.dto.LoginResponseDto
import org.json.JSONObject

class LoginRemoteDataSourceImpl(
    val client: CommunicationClient<BaseHttpRequest, BaseHttpResponse>,
    val logger: Logger
) : LoginRemoteDataSource {

    override suspend fun login(username: String, password: String): LoginResponseDto {
        return try {
            val json = JSONObject()
            json.put("username", username)
            json.put("password", password)
            logger.info("username: $username, password: $password")

            val response = client.execute(
                HttpJsonRequest(
                    method = HttpMethod.POST,
                    path = "/login",
                    json = json
                )
            )

            logger.info("Código: ${response.code}, Corpo: ${response.body}")

            val responseJson = response.toJsonObject()

            LoginResponseDto(
                token =  responseJson.getString("token"),
                userId =  responseJson.getString("userId"),
                name = username,
                expiresIn = System.currentTimeMillis() + 3600 * 1000
            )
        } catch (_: Exception) {
            LoginResponseDto(
                name = username,
                expiresIn = System.currentTimeMillis()
            )
        }
    }
}