package com.imgego.android_kotlin_boilerplate.presentation.login.state

import com.imgego.android_kotlin_boilerplate.R
import com.imgego.android_kotlin_boilerplate.common.state.ErrorState


val emailEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)