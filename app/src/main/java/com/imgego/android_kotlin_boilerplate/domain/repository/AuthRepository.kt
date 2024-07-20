package com.imgego.android_kotlin_boilerplate.domain.repository

import com.imgego.android_kotlin_boilerplate.data.remote.request.AuthRequest
import com.imgego.android_kotlin_boilerplate.util.Resource

interface AuthRepository {
    suspend fun login(loginRequest: AuthRequest):Resource<Unit>
    suspend fun register(registerRequest: AuthRequest):Resource<Unit>
}