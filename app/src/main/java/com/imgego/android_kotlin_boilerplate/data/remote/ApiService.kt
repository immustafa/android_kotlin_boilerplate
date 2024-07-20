package com.imgego.android_kotlin_boilerplate.data.remote

import com.imgego.android_kotlin_boilerplate.data.remote.request.AuthRequest
import com.imgego.android_kotlin_boilerplate.data.remote.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("api/login")
    suspend fun loginUser(
        @Body loginRequest: AuthRequest
    ) : AuthResponse


    @POST("api/register")
    suspend fun registerUser(
        @Body registerRequest: AuthRequest
    ) : AuthResponse

    @GET("api/user/{id}")
    suspend fun getUserDetails()

}