package com.pranay.jetkite.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.login.LoginScreen
import com.pranay.jetkite.navigation.JetKiteNavDestination

object LoginDestination : JetKiteNavDestination {
    override val route = "login_route"
    override val destination = "login_destination"
}

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(LoginDestination.route, navOptions)
}

fun NavGraphBuilder.loginScreen(
    onNavigationBackClick: () -> Unit = {},
    onForgotClick: () -> Unit = {},
    onSwitchAccountClick: () -> Unit = {},
    onLoginSuccess: () -> Unit
) {
    composable(route = LoginDestination.route) {
        LoginScreen(
            onNavigationBackClick = onNavigationBackClick,
            onForgotClick = onForgotClick,
            onSwitchAccountClick = onSwitchAccountClick,
            onLoginSuccess = onLoginSuccess
        )
    }
}
