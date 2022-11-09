package com.pranay.jetkite.dashboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.pranay.jetkite.components.JetKiteNavigationBar
import com.pranay.jetkite.components.JetKiteNavigationBarItem
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.dashboard.navigation.TopLevelDestination
import com.pranay.jetkite.dashboard.ui.JetKiteHomeNavHost
import com.pranay.jetkite.designsystem.JetKiteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    appState: HomeNavigationAppState = rememberHomeNavigationState(),
    onNavigationBackClick: () -> Unit = {}
) {
    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            JetKiteBottomBar(
                destinations = appState.topLevelDestinations,
                onNavigateToDestination = appState::navigate,
                currentDestination = appState.currentDestination
            )
        }
    ) { padding ->
        Row(
            Modifier
                .fillMaxSize()
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal
                    )
                )
        ) {
            JetKiteHomeNavHost(
                navController = appState.navController,
                onNavigateToDestination = appState::navigate,
                onBackClick = appState::onBackClick,
                modifier = Modifier
                    .padding(padding),
                isExpandedScreen = false
            )
        }
    }
}

@Composable
private fun JetKiteBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    JetKiteNavigationBar {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            JetKiteNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )

                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

@LightDarkPreview
@Composable
fun HomeScreenPreview() {
    JetKiteTheme {
        HomeScreen {}
    }
}
