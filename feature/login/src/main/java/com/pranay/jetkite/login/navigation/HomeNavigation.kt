package com.pranay.jetkite.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.login.HomeScreen
import com.pranay.jetkite.navigation.JetKiteNavDestination

object HomeDestination : JetKiteNavDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(HomeDestination.route, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onNavigationBackClick: () -> Unit = {}
) {
    composable(route = HomeDestination.route) {
        HomeScreen(
            onNavigationBackClick = onNavigationBackClick
        )
    }
}
