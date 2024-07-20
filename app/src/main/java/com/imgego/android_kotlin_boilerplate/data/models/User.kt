package com.imgego.android_kotlin_boilerplate.data.models

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("email")
    var email: String? = null,
    @SerializedName("username")
    var userName: String? = null,
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("bio")
    var bio: String? = null,
    @SerializedName("photo")
    var photo: String? = null
)