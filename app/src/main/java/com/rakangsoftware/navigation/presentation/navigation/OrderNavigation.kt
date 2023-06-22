package com.rakangsoftware.navigation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rakangsoftware.navigation.presentation.features.order.detail.OrderDetailScreenView
import com.rakangsoftware.navigation.presentation.features.order.list.OrderListScreenView

sealed class OrderScreen(val route: String) {
    object List : OrderScreen(route = "order")
    object Detail : OrderScreen(route = "order/{orderId}") {
        fun getRoute(orderId: Int) = "order/$orderId"
    }
}

@Composable
fun OrderNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = OrderScreen.List.route,
        modifier = modifier,
    ) {
        addOrderListScreen(navController, modifier)
        addOrderDetailScreen(navController, modifier)
    }
}

private fun NavGraphBuilder.addOrderListScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    composable(
        route = OrderScreen.List.route,
    ) {
        OrderListScreenView(
            onOrderTapped = { orderId ->
                navController.navigate(
                    OrderScreen.Detail.getRoute(orderId)
                )
            },
            modifier = modifier
        )
    }
}

private fun NavGraphBuilder.addOrderDetailScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    composable(
        route = OrderScreen.Detail.route,
        arguments = listOf(
            navArgument(
                name = "orderId"
            ) {
                type = NavType.IntType
                defaultValue = -1
            }
        )
    ) {
        val orderId = it.arguments?.getInt("orderId") ?: -1
        OrderDetailScreenView(
            orderId,
            onBackTapped = {
                navController.popBackStack()
            }, modifier = modifier
        )
    }
}