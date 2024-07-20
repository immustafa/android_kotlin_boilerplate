package com.imgego.android_kotlin_boilerplate.presentation.bottomnav

import android.content.res.Configuration
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.imgego.android_kotlin_boilerplate.ui.theme.AndroidKotlinBoilerplateTheme

@Composable
fun BottomNav(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    )
    {
        Modifier.padding(it)
        BottomNavGraph(
            navController = navController
        )
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
//        BottomNavScreen.Home,
//        BottomNavScreen.Profile,
        NavigationRoutes.Unauthenticated.Home,
        NavigationRoutes.Authenticated.Profile
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier
    ) {

        screens.forEach { screen ->

            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomNavigationItem(
                icon = {
                    screen.selectedIcon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = screen.title,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                label = {
                    screen.title?.let {
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                selected = selected,
                onClick = {
                    screen.route?.let {
                        navController.navigate(it) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                                inclusive = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selectedContentColor = LocalContentColor.current,
                unselectedContentColor = LocalContentColor.current,
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}

@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
fun BottomNavPreview() {
    val navController = rememberNavController()
    AndroidKotlinBoilerplateTheme {
        BottomNav(navController = navController)
    }
}














