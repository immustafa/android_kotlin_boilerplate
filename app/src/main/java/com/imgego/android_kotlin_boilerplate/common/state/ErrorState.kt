package com.imgego.android_kotlin_boilerplate.common.state

import androidx.annotation.StringRes
import com.imgego.android_kotlin_boilerplate.R


/**
 * Error state holding values for error ui
 */
data class ErrorState(
    val hasError: Boolean = false,
    @StringRes val errorMessageStringResource: Int = R.string.empty_string
)