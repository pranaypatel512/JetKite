package com.pranay.jetkite.dashboard.ui.tools

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.navigation.JetKiteNavDestination

object ToolsDestination : JetKiteNavDestination {
    override val route = "tools_route"
    override val destination = "tools_destination"
}

fun NavController.navigateTools(navOptions: NavOptions? = null) {
    this.navigate(ToolsDestination.route, navOptions)
}

fun NavGraphBuilder.toolsScreen(
    onNavigationBackClick: () -> Unit = {}
) {
    composable(route = ToolsDestination.route) {
        ToolsScreen(
            onNavigationBackClick = onNavigationBackClick
        )
    }
}
