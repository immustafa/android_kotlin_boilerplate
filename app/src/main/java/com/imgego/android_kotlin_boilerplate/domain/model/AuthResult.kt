package com.imgego.android_kotlin_boilerplate.domain.model

import com.imgego.android_kotlin_boilerplate.util.Resource

data class AuthResult(
    val passwordError: String? = null,
    val emailError : String? = null,
    val result: Resource<Unit>? = null
)