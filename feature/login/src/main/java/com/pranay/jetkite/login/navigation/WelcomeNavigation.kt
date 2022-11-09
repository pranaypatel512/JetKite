package com.pranay.jetkite.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.login.WelcomeScreen
import com.pranay.jetkite.navigation.JetKiteNavDestination

object WelcomeDestination : JetKiteNavDestination {
    override val route = "welcome_route"
    override val destination = "welcome_destination"
}

fun NavController.navigateToWelcome(navOptions: NavOptions? = null) {
    this.navigate(WelcomeDestination.route, navOptions)
}

fun NavGraphBuilder.welcomeScreen(
    onNavigationBackClick: () -> Unit = {},
    onActionLoginClick: () -> Unit = {},
    onActionSignUpClick: () -> Unit = {}
) {
    composable(route = WelcomeDestination.route) {
        WelcomeScreen(
            onNavigationBackClick = onNavigationBackClick,
            onActionLoginClick = onActionLoginClick,
            onActionSignUpClick = onActionSignUpClick
        )
    }
}
