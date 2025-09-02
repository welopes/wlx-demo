package br.com.wlx.demo.login.data.remote.impl

import br.com.wlx.communication.api.ApiClient
import br.com.wlx.communication.api.ApiResult
import br.com.wlx.demo.login.data.remote.LoginRemoteDataSource
import br.com.wlx.demo.login.data.remote.dto.LoginResponseDto
import org.json.JSONObject

class LoginRemoteDataSourceImpl(
    val apiClient: ApiClient
) : LoginRemoteDataSource {

    override suspend fun login(username: String, password: String): LoginResponseDto {

        return apiClient
            .post(
                "/login",
                JSONObject()
                    .put("username", username)
                    .put("password", password),
                LoginResponseDto::class.java
            ).let {
                when (it) {
                    is ApiResult.Success -> {
                        it.data
                    }

                    is ApiResult.Error -> {
                        // logger?.error("Login failed", it.throwable)
                        LoginResponseDto()
                    }
                }
            }
    }
}