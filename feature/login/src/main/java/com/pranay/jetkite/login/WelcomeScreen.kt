package com.pranay.jetkite.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.components.JetKiteLogo
import com.pranay.jetkite.components.extension.SystemBarsPaddingSpacer

@Composable
fun WelcomeScreen(
    onNavigationBackClick: () -> Unit = {},
    onActionLoginClick: () -> Unit = {},
    onActionSignUpClick: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SystemBarsPaddingSpacer()
        JetKiteLogo()
    }
}

@Composable
@Preview
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
