package com.rakangsoftware.navigation.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.rakangsoftware.navigation.presentation.features.profile.ProfileScreenView

sealed class RootScreen(val route: String, val deeplink: String, val icon: ImageVector) {
    object Order : RootScreen(
        route = "order",
        deeplink = "https://navigation.rakangsoftware.com/order",
        icon = Icons.Outlined.List
    )

    object Profile : RootScreen(
        route = "profile",
        deeplink = "https://navigation.rakangsoftware.com/profile",
        icon = Icons.Outlined.Person
    )

    companion object {
        fun getAll() = listOf(Order, Profile)
    }
}

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    var selectedScreen by remember { mutableStateOf<RootScreen>(RootScreen.Profile) }

    val mainScreens = RootScreen.getAll()

    Scaffold(
        content = { paddingValues ->
            NavHost(
                navController = navController, startDestination = RootScreen.Order.route,
            ) {
                addOrderNavGraphScreen( modifier = Modifier.padding(paddingValues))
                addProfileScreen(modifier = Modifier.padding(paddingValues))
            }
        },
        bottomBar = {
            BottomNavigation(
                selectedItem = selectedScreen,
                onItemSelected = { screen ->
                    selectedScreen = screen
                    navController.navigate(screen.route)
                },
                mainScreens,
            )
        }
    )
}

private fun NavGraphBuilder.addOrderNavGraphScreen(
    modifier: Modifier = Modifier
) {
    composable(
        route = RootScreen.Order.route
    ) {
        OrderNavigation(modifier)
    }
}

private fun NavGraphBuilder.addProfileScreen(
    modifier: Modifier = Modifier
) {
    composable(
        route = RootScreen.Profile.route,
        deepLinks = listOf(
            navDeepLink { uriPattern = RootScreen.Profile.deeplink }
        ),
    ) {
        ProfileScreenView(modifier)
    }
}

@Composable
private fun BottomNavigation(
    selectedItem: RootScreen,
    onItemSelected: (RootScreen) -> Unit,
    screens: List<RootScreen>,
) {
    BottomAppBar(
        backgroundColor = Color(0xFF162A3D),
        contentColor = Color.White,
        cutoutShape = CircleShape
    ) {
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(screen.icon, contentDescription = null)
                },
                onClick = { onItemSelected(screen) },
                selected = selectedItem == screen,
            )
        }
    }
}