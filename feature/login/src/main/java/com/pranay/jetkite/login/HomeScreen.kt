package com.pranay.jetkite.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pranay.jetkite.components.JetKiteLogo
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun HomeScreen(
    onNavigationBackClick: () -> Unit = {}
) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(horizontal = MaterialTheme.spacing.medium),
            verticalArrangement = Arrangement.Center
        ) {
            JetKiteLogo(
                modifier = Modifier
                    .size(height = MaterialTheme.spacing.largeImage, width = MaterialTheme.spacing.largeImage)
                    .padding(vertical = MaterialTheme.spacing.medium)
            )
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.large))
            JetKiteTextView(
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
                text = stringResource(R.string.welcome_to_jetkite),
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@LightDarkPreview
@Composable
fun HomeScreenPreview() {
    JetKiteTheme {
        HomeScreen {}
    }
}
