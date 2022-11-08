package com.pranay.jetkite.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.login.SplashScreen
import com.pranay.jetkite.navigation.JetKiteNavDestination

object SplashDestination : JetKiteNavDestination {
    override val route = "splash_route"
    override val destination = "splash_destination"
}

fun NavController.navigateToSplash(navOptions: NavOptions? = null) {
    this.navigate(SplashDestination.route, navOptions)
}

fun NavGraphBuilder.splashScreen(onLoadingCompleted: () -> Unit) {
    composable(route = SplashDestination.route) {
        SplashScreen(onLoadingCompleted = onLoadingCompleted)
    }
}
