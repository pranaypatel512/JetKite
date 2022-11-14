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

package com.pranay.jetkite.dashboard.navigation

import androidx.compose.runtime.Immutable
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.components.icons.Icon.DrawableResourceIcon
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.dashboard.R

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int
) {
    WATCH_LIST(
        selectedIcon = DrawableResourceIcon(JetKiteIcons.Bookmark),
        unselectedIcon = DrawableResourceIcon(JetKiteIcons.BookmarkBorder),
        iconTextId = R.string.watchlist
    ),
    ORDERS(
        selectedIcon = DrawableResourceIcon(JetKiteIcons.Orders),
        unselectedIcon = DrawableResourceIcon(JetKiteIcons.OrdersBorder),
        iconTextId = R.string.orders
    ),
    PORTFOLIO(
        selectedIcon = DrawableResourceIcon(JetKiteIcons.Portfolio),
        unselectedIcon = DrawableResourceIcon(JetKiteIcons.PortfolioBorder),
        iconTextId = R.string.portfolio
    ),
    TOOLS(
        selectedIcon = DrawableResourceIcon(JetKiteIcons.Tools),
        unselectedIcon = DrawableResourceIcon(JetKiteIcons.ToolsBorder),
        iconTextId = R.string.tools
    ),
    PROFILE(
        selectedIcon = DrawableResourceIcon(JetKiteIcons.Profile),
        unselectedIcon = DrawableResourceIcon(JetKiteIcons.ProfileBorder),
        iconTextId = R.string.profile
    )
}

@Immutable
data class TopLevelDestinationList(val items: List<TopLevelDestination>)
