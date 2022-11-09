package com.pranay.jetkite.dashboard.ui.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.navigation.JetKiteNavDestination

object ProfileDestination : JetKiteNavDestination {
    override val route = "profile_route"
    override val destination = "profile_destination"
}

fun NavController.navigateProfile(navOptions: NavOptions? = null) {
    this.navigate(ProfileDestination.route, navOptions)
}

fun NavGraphBuilder.profileScreen(
    onNavigationBackClick: () -> Unit = {}
) {
    composable(route = ProfileDestination.route) {
        ProfileScreen(
            onNavigationBackClick = onNavigationBackClick
        )
    }
}
