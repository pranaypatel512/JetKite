package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.navigation.JetKiteNavDestination

object WatchListDestination : JetKiteNavDestination {
    override val route = "watch_list_route"
    override val destination = "watch_list_destination"
}

fun NavController.navigateWatchList(navOptions: NavOptions? = null) {
    this.navigate(WatchListDestination.route, navOptions)
}

fun NavGraphBuilder.watchListScreen(
    onNavigationBackClick: () -> Unit = {}
) {
    composable(route = WatchListDestination.route) {
        WatchListScreen(
            onNavigationBackClick = onNavigationBackClick
        )
    }
}
