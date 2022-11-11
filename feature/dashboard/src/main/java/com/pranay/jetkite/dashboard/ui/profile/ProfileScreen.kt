package com.pranay.jetkite.dashboard.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.extension.LightDarkPreviews
import com.pranay.jetkite.components.extension.SystemBarsPaddingSpacer
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onNavigationBackClick: () -> Unit = {}
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = MaterialTheme.spacing.medium)
        ) {
            SystemBarsPaddingSpacer()
            JetKiteTextView(
                text = "Profile Screen",
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@LightDarkPreviews
@Composable
fun ProfileScreenPreview() {
    JetKiteTheme {
        ProfileScreen()
    }
}
