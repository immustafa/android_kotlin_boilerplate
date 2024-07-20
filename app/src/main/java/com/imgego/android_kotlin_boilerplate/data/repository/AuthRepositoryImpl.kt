package com.imgego.android_kotlin_boilerplate.data.repository

import android.content.SharedPreferences
import com.imgego.android_kotlin_boilerplate.data.local.AuthPreferences
import com.imgego.android_kotlin_boilerplate.data.remote.ApiService
import com.imgego.android_kotlin_boilerplate.data.remote.request.AuthRequest
import com.imgego.android_kotlin_boilerplate.domain.repository.AuthRepository
import com.imgego.android_kotlin_boilerplate.util.Resource
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val apiService: ApiService,
    private val preferences: AuthPreferences

) : AuthRepository{
    override suspend fun login(loginRequest: AuthRequest): Resource<Unit> {
       return try {
           val response = apiService.loginUser(loginRequest)
           response.token?.let { preferences.saveAuthToken(it) }
           Resource.Success(Unit)
       }catch (e: IOException){
           Resource.Error("${e.message}")
       }catch (e: HttpException){
           Resource.Error("${e.message}")
       }
    }

    override suspend fun register(registerRequest: AuthRequest): Resource<Unit> {
        return try {
           val response = apiService.registerUser(registerRequest)
            response.token?.let { preferences.saveAuthToken(it) }
            Resource.Success(Unit)
        }catch (e: IOException){
            Resource.Error("${e.message}")
        }catch (e: HttpException){
            Resource.Error("${e.message}")
        }
    }


}