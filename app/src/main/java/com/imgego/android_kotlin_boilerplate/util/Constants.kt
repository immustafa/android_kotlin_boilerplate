package com.imgego.android_kotlin_boilerplate.util

import androidx.datastore.preferences.core.stringSetPreferencesKey


object Constants {
    const val BASE_URL = "https://api.yomment.com/api/"
    const val AUTH_PREFERENCES = "AUTH_PREF"
    val AUTH_KEY = stringSetPreferencesKey("auth_key")
}