package com.imgego.android_kotlin_boilerplate.domain.use_case

import com.imgego.android_kotlin_boilerplate.data.remote.request.AuthRequest
import com.imgego.android_kotlin_boilerplate.domain.model.AuthResult
import com.imgego.android_kotlin_boilerplate.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email:String,
        password:String
    ):AuthResult {

        val emailError = if (email.isBlank()) "Email cannot be blank" else null
        val passwordError = if (password.isBlank()) "Password cannot be blank" else null

        if (emailError != null){
            return AuthResult(
                emailError = emailError
            )
        }

        if (passwordError!=null){
            return AuthResult(
                passwordError = passwordError
            )
        }

        val loginRequest = AuthRequest(
            email = email.trim(),
            password = password.trim()
        )

        return AuthResult(
            result = repository.login(loginRequest)
        )
    }
}