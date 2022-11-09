package com.pranay.jetkite.dashboard.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pranay.jetkite.dashboard.navigation.TopLevelDestination
import com.pranay.jetkite.dashboard.navigation.WatchListDestination
import com.pranay.jetkite.dashboard.navigation.watchListScreen

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun JetKiteHomeNavHost(
    navController: NavHostController,
    onNavigateToDestination: (TopLevelDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = WatchListDestination.route,
    isExpandedScreen: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        watchListScreen {
        }
    }
}
