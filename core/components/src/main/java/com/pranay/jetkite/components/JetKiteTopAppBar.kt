package com.pranay.jetkite.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetKiteTopAppBar(
    @StringRes titleRes: Int,
    @DrawableRes actionIcon: Int,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            JetKiteTextView(
                text = stringResource(id = titleRes),
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
        },
        /*navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },*/
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    painter = painterResource(id = actionIcon),
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        },
        colors = colors,
        modifier = modifier
    )
}
