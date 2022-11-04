package com.pranay.jetkite.login

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pranay.jetkite.components.JetKiteLogo
import com.pranay.jetkite.components.extension.LightDarkPreview
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun LoadingScreen(
    onNavigationBackClick: () -> Unit = {},
    onLoadingCompleted: () -> Unit = {}
) {
    val progressValue = 1f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,
        animationSpec = infiniteRepeatable(animation = tween(5000))
    )

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
            LinearProgressIndicator(progress = progressAnimationValue)
        }
    }
}

@LightDarkPreview
@Composable
fun LoadingScreenPreview() {
    JetKiteTheme {
        LoadingScreen()
    }
}
