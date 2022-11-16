package com.pranay.jetkite.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.zIndex
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.pranay.jetkite.components.JetKiteNavigationBar
import com.pranay.jetkite.components.JetKiteNavigationBarItem
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.JetKiteTopAppBar
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.icons.Icon
import com.pranay.jetkite.dashboard.navigation.TopLevelDestination
import com.pranay.jetkite.dashboard.navigation.TopLevelDestinationList
import com.pranay.jetkite.dashboard.ui.JetKiteHomeNavHost
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    appState: HomeNavigationAppState = rememberHomeNavigationState(),
    onNavigationBackClick: () -> Unit = {}
) {
    val topBarTitle = remember { mutableStateOf(R.string.market_watch) }
    val marketWatchVisibility = remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)) {
        AnimatedVisibility(visible = marketWatchVisibility.value) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(MaterialTheme.spacing.dp100)
                    .background(MaterialTheme.colorScheme.surface).padding(start = MaterialTheme.spacing.dp12),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = {
                    marketWatchVisibility.value = !marketWatchVisibility.value
                }, modifier = Modifier.align(Alignment.TopEnd)) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(id = R.string.str_close),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                JetKiteTextView(
                    text = stringResource(id = R.string.str_overview),
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                    modifier = Modifier.align(Alignment.TopStart).padding(vertical = MaterialTheme.spacing.dp12)
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth(),

            contentAlignment = Alignment.Center
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
                },
                topBar = {
                    JetKiteTopAppBar(
                        titleRes = topBarTitle.value,
                        actionIcon = com.pranay.jetkite.components.R.drawable.baseline_keyboard_arrow_down_24,
                        actionIconContentDescription = stringResource(id = R.string.market_watch),
                        onActionClick = {
                            marketWatchVisibility.value = !marketWatchVisibility.value
                        }
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
            if (marketWatchVisibility.value) {
                Box(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f)).zIndex(10f)
                        .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                            marketWatchVisibility.value = !marketWatchVisibility.value
                        }
                )
            }
        }
    }
}

@Composable
private fun JetKiteBottomBar(
    destinations: TopLevelDestinationList,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    JetKiteNavigationBar {
        destinations.items.forEach { destination ->
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

@LightDarkPreviews
@Composable
fun HomeScreenPreview() {
    JetKiteTheme {
        HomeScreen {}
    }
}
