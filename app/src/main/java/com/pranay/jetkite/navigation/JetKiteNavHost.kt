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

package com.pranay.jetkite.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pranay.jetkite.dashboard.navigation.HomeDestination
import com.pranay.jetkite.dashboard.navigation.homeScreen
import com.pranay.jetkite.login.navigation.LoginDestination
import com.pranay.jetkite.login.navigation.SplashDestination
import com.pranay.jetkite.login.navigation.WelcomeDestination
import com.pranay.jetkite.login.navigation.loginScreen
import com.pranay.jetkite.login.navigation.splashScreen
import com.pranay.jetkite.login.navigation.welcomeScreen

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun JetKiteNavHost(
    navController: NavHostController,
    onNavigateToDestination: (JetKiteNavDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = SplashDestination.route,
    isExpandedScreen: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        splashScreen {
            onNavigateToDestination(WelcomeDestination, WelcomeDestination.route)
        }
        welcomeScreen(onActionLoginClick = {
            onNavigateToDestination(LoginDestination, LoginDestination.route)
        }, onActionSignUpClick = {}, onNavigationBackClick = {})
        loginScreen(
            onLoginSuccess = {
                onNavigateToDestination(HomeDestination, HomeDestination.route)
            },
            onNavigationBackClick = {},
            onForgotClick = {
            },
            onSwitchAccountClick = {
            }
        )
        homeScreen {
            onNavigateToDestination(WelcomeDestination, WelcomeDestination.route)
        }
    }
}
