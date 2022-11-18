package com.pranay.jetkite.dashboard.ui.watchlist

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.dashboard.R
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.colorSearchBackground
import com.pranay.jetkite.designsystem.colorSearchTextDark
import com.pranay.jetkite.designsystem.colorSearchTextLight
import com.pranay.jetkite.designsystem.color_white
import com.pranay.jetkite.designsystem.spacing
import kotlinx.coroutines.CoroutineScope

@OptIn(
    ExperimentalLifecycleComposeApi::class,
    ExperimentalPagerApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun WatchListSearch(
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    totalWatchListItem: String? = null,
    backgroundColor: Color = if (isSystemInDarkTheme()) colorSearchBackground else color_white,
    textColor: Color = if (isSystemInDarkTheme()) colorSearchTextDark else colorSearchTextLight,
    onValueChange: (TextFieldValue) -> Unit
) {
    var searchValue by remember { mutableStateOf(TextFieldValue("")) }
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(MaterialTheme.spacing.extraSmall),
        color = backgroundColor,
        shadowElevation = MaterialTheme.spacing.extraSmall
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(TextFieldDefaults.MinHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
        ) {
            OutlinedTextField(
                value = searchValue,
                onValueChange = {
                    searchValue = it
                    onValueChange.invoke(it)
                },
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = JetKiteIcons.Search,
                            contentDescription = stringResource(id = R.string.str_search),
                            tint = textColor
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = textColor,
                    cursorColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedLabelColor = MaterialTheme.colorScheme.outline,
                    focusedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    containerColor = Color.Transparent,
                    unfocusedTrailingIconColor = MaterialTheme.colorScheme.outline,
                    focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
            totalWatchListItem?.let {
                JetKiteTextView(text = it)
            }
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = MaterialTheme.spacing.dp12)
                    .width(MaterialTheme.spacing.dp1)
            )
            IconButton(onClick = onFilterClick) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = stringResource(id = R.string.str_search),
                    tint = textColor
                )
            }
        }
    }
}

@LightDarkPreviews
@Composable
fun WatchListSearchPreview() {
    JetKiteTheme {
        WatchListSearch(onFilterClick = {}) {
        }
    }
}
