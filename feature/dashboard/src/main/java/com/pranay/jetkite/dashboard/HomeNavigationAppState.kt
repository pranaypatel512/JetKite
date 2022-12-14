/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pranay.jetkite.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.pranay.jetkite.dashboard.navigation.TopLevelDestination
import com.pranay.jetkite.dashboard.navigation.TopLevelDestinationList
import com.pranay.jetkite.dashboard.ui.orders.navigateOrders
import com.pranay.jetkite.dashboard.ui.portfolio.navigatePortfolio
import com.pranay.jetkite.dashboard.ui.profile.navigateProfile
import com.pranay.jetkite.dashboard.ui.tools.navigateTools
import com.pranay.jetkite.dashboard.ui.watchlist.navigateWatchList

@Composable
fun rememberHomeNavigationState(
    navController: NavHostController = rememberNavController()
): HomeNavigationAppState {
    return remember(navController) {
        HomeNavigationAppState(navController)
    }
}

@Stable
class HomeNavigationAppState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    /**
     * Top level destinations to be used in the BottomBar and NavRail
     */
    val topLevelDestinations: TopLevelDestinationList = TopLevelDestinationList(TopLevelDestination.values().asList())

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigate(
        topLevelDestination: TopLevelDestination,
        route: String? = null,
        clearStack: Boolean = true
    ) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
            if (clearStack) {
                popUpTo(0)
            }
        }

        when (topLevelDestination) {
            TopLevelDestination.WATCH_LIST -> navController.navigateWatchList(topLevelNavOptions)
            TopLevelDestination.ORDERS -> navController.navigateOrders(topLevelNavOptions)
            TopLevelDestination.PORTFOLIO -> navController.navigatePortfolio(topLevelNavOptions)
            TopLevelDestination.TOOLS -> navController.navigateTools(topLevelNavOptions)
            TopLevelDestination.PROFILE -> navController.navigateProfile(topLevelNavOptions)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}
