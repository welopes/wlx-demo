package br.com.wlx.login.data.remote.impl

import br.com.wlx.communication.api.HttpTaskService
import br.com.wlx.communication.api.model.HttpMethod
import br.com.wlx.communication.api.request.HttpJsonRequest
import br.com.wlx.communication.api.util.toObject
import br.com.wlx.login.data.remote.LoginRemoteDataSource
import br.com.wlx.login.data.remote.dto.LoginResponseDto
import org.json.JSONObject

class LoginRemoteDataSourceImpl(
    val service: HttpTaskService
) : LoginRemoteDataSource {

    override suspend fun login(username: String, password: String): LoginResponseDto {

        val json = JSONObject()
        json.put("username", username)
        json.put("password", password)

        return service.create(
            HttpJsonRequest(
                method = HttpMethod.POST,
                path = "/login",
                json = json
            )
        ).execute().toObject()
    }
}