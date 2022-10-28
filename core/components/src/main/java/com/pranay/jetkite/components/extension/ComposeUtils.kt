package com.pranay.jetkite.components.extension

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SystemBarsPaddingSpacer() {
    Spacer(modifier = Modifier.systemBarsPadding())
}
