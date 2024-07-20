package com.imgego.android_kotlin_boilerplate

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.imgego.android_kotlin_boilerplate.presentation.bottomnav.BottomNav
import com.imgego.android_kotlin_boilerplate.presentation.bottomnav.NavigationRoutes
import com.imgego.android_kotlin_boilerplate.presentation.bottomnav.NavigationRoutes.*
import com.imgego.android_kotlin_boilerplate.presentation.bottomnav.authenticatedGraph
import com.imgego.android_kotlin_boilerplate.presentation.bottomnav.unauthenticatedGraph


@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        topBar = { MainAppBar() },
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding).fillMaxSize()
        androidx.compose.material3.Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            BottomNav(navController)
        }
    }


}



@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun MainAppBar() {
    TopAppBar(
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        // modifier = Modifier.height(58.dp)
        modifier = Modifier
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.app_name),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
