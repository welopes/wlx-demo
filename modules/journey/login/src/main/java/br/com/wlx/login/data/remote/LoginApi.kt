package br.com.wlx.login.data.remote

import br.com.wlx.login.data.model.LoginResponseDto

class LoginApi {
    fun login(username: String, password: String): LoginResponseDto {
        return LoginResponseDto("user_id_example", "User Name Example", "access_token_example")
    }

}
