package com.imgego.android_kotlin_boilerplate.presentation.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imgego.android_kotlin_boilerplate.R
import com.imgego.android_kotlin_boilerplate.common.composableViews.TitleText
import com.imgego.android_kotlin_boilerplate.presentation.login.LoginScreen
import com.imgego.android_kotlin_boilerplate.presentation.login.LoginViewModel
import com.imgego.android_kotlin_boilerplate.ui.theme.AndroidKotlinBoilerplateTheme


@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = viewModel(),
    onNavigateToUnAuthenticatedRoute: () -> Unit
) {

    val loginState by remember {
        loginViewModel.loginState
    }

    if (loginState.isLoginSuccessful) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TitleText(text = stringResource(id = R.string.profile_title_welcome_user))
        }
    } else {
        LaunchedEffect(key1 = true) {
            onNavigateToUnAuthenticatedRoute.invoke()
        }
    }

}


@Composable
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
fun PreviewProfileScreen() {
    AndroidKotlinBoilerplateTheme {
        ProfileScreen(
            onNavigateToUnAuthenticatedRoute = {}
        )
    }
}
