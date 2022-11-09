package com.pranay.jetkite.dashboard.ui.portfolio

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.pranay.jetkite.navigation.JetKiteNavDestination

object PortfolioDestination : JetKiteNavDestination {
    override val route = "portfolio_route"
    override val destination = "portfolio_destination"
}

fun NavController.navigatePortfolio(navOptions: NavOptions? = null) {
    this.navigate(PortfolioDestination.route, navOptions)
}

fun NavGraphBuilder.portfolioScreen(
    onNavigationBackClick: () -> Unit = {}
) {
    composable(route = PortfolioDestination.route) {
        PortfolioScreen(
            onNavigationBackClick = onNavigationBackClick
        )
    }
}
