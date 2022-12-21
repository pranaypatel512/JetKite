package com.pranay.jetkite.dashboard.ui.orders

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.navigation.JetKiteNavDestination

object OrdersDestination : JetKiteNavDestination {
    override val route = "orders_route"
    override val destination = "orders_destination"
}

fun NavController.navigateOrders(navOptions: NavOptions? = null) {
    this.navigate(OrdersDestination.route, navOptions)
}

fun NavGraphBuilder.ordersScreen(
    onNavigationBackClick: () -> Unit = {}
) {
    composable(route = OrdersDestination.route) {
        OrdersScreen(
            onNavigationBackClick = onNavigationBackClick
        )
    }
}
