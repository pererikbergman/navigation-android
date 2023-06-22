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
import com.rakangsoftware.navigation.presentation.features.orders.OrdersScreenView
import com.rakangsoftware.navigation.presentation.features.profile.ProfileScreenView

sealed class RootScreen(val route: String, val icon: ImageVector) {
    object Orders : RootScreen("orders", Icons.Outlined.List)
    object Profile : RootScreen("profile", Icons.Outlined.Person)

    companion object {
        fun getAll() = listOf(Orders, Profile)
    }
}

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    var selectedScreen by remember { mutableStateOf<RootScreen>(RootScreen.Orders) }

    val mainScreens = RootScreen.getAll()

    Scaffold(
        content = { paddingValues ->
            NavHost(
                navController = navController, startDestination = RootScreen.Orders.route,
            ) {
                addOrdersScreen(navController, modifier = Modifier.padding(paddingValues))
                addProfileScreen(navController, modifier = Modifier.padding(paddingValues))
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

private fun NavGraphBuilder.addOrdersScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    composable(
        route = RootScreen.Orders.route,
    ) {
        OrdersScreenView(modifier)
    }
}

private fun NavGraphBuilder.addProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    composable(
        route = RootScreen.Profile.route,
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