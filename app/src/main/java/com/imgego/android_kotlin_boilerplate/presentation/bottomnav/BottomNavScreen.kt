package com.imgego.android_kotlin_boilerplate.presentation.bottomnav


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavigationRoutes {

    abstract val title: String?
    abstract val selectedIcon: ImageVector?
    abstract val route: String?

    // Unauthenticated Routes
    sealed class Unauthenticated(
        override val route: String,
        override val title: String? = null,
        override val selectedIcon: ImageVector? = null,
        val unselectedIcon: ImageVector? = null,
        val hasBadge: Boolean? = null,
        val badgeCount: Int? = null
    ) : NavigationRoutes() {
        data object NavigationRoute : Unauthenticated(route = "unauthenticated")
        data object Home : Unauthenticated(
            route = "home",
            title = "Home",
            selectedIcon = Icons.Rounded.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false,
            badgeCount = null
        )

        data object Login : Unauthenticated(route = "login")
        data object Registration : Unauthenticated(route = "registration")
    }

    // Authenticated Routes
    sealed class Authenticated(
        override val route: String,
        override val title: String? = null,
        override val selectedIcon: ImageVector? = null,
        val unselectedIcon: ImageVector? = null,
        val hasBadge: Boolean? = null,
        val badgeCount: Int? = null
    ) : NavigationRoutes() {
        data object NavigationRoute : Authenticated(route = "authenticated")

        //        data object Profile : Authenticated(route = "profile")
        data object Profile : Authenticated(
            route = "profile",
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasBadge = false
        )
    }
}
