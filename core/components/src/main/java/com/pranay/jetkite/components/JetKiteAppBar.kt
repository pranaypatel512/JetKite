package com.pranay.jetkite.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetKiteAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    colors: TopAppBarColors = TopAppBarDefaults.smallTopAppBarColors(),
    navigationIcon: @Composable
    () -> Unit = { },
    actionIcon: @Composable
    () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            title?.let {
                Text(title, style = MaterialTheme.typography.headlineMedium)
            }
        },
        colors = colors,
        navigationIcon = navigationIcon,
        actions = {
            actionIcon()
        }
    )
}

@Composable
fun JetBackArrow(onBackClick: () -> Unit = {}) {
    IconButton(onClick = { onBackClick() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(
                id = R.string.back
            )
        )
    }
}
