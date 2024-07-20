package com.imgego.android_kotlin_boilerplate.data.remote.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("username")
    var userName: String? = null,
    @SerializedName("token")
    var token: String? = null,
)