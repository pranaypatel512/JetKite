package com.pranay.jetkite.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.components.JetKiteDivider
import com.pranay.jetkite.components.JetKiteLogo
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.R
import com.pranay.jetkite.components.TextViewWithEndIcon
import com.pranay.jetkite.components.extension.SystemBarsPaddingSpacer
import com.pranay.jetkite.components.icons.JetKiteIcons
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.designsystem.spacing

@Composable
fun WelcomeScreen(
    onNavigationBackClick: () -> Unit = {},
    onActionLoginClick: () -> Unit = {},
    onActionSignUpClick: () -> Unit = {}
) {
    Surface {
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = MaterialTheme.spacing.medium)) {
            SystemBarsPaddingSpacer()
            JetKiteLogo(
                modifier = Modifier
                    .size(height = MaterialTheme.spacing.largeImage, width = MaterialTheme.spacing.dp100)
                    .padding(vertical = MaterialTheme.spacing.medium)
            )
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.large))
            JetKiteTextView(text = "Welcome to JetKite", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.large))
            JetKiteDivider(thickness = MaterialTheme.spacing.dp1)
            TextViewWithEndIcon(
                modifier = Modifier.fillMaxWidth().padding(vertical = MaterialTheme.spacing.medium),
                text = stringResource(id = R.string.login_to_kite),
                iconRes = JetKiteIcons.Login
            )
            JetKiteDivider(thickness = MaterialTheme.spacing.dp1)
            TextViewWithEndIcon(
                modifier = Modifier.fillMaxWidth().padding(vertical = MaterialTheme.spacing.medium),
                text = stringResource(id = R.string.open_new_account),
                iconRes = JetKiteIcons.Login
            )
            JetKiteDivider(thickness = MaterialTheme.spacing.dp1)
        }
    }
}

@Preview(showSystemUi = true, device = "spec:width=411dp,height=891dp")
@Preview(showSystemUi = true, device = "spec:width=673.5dp,height=841dp,dpi=480")
@Preview(showSystemUi = true, device = "spec:width=1280dp,height=800dp,dpi=480")
@Preview(showSystemUi = true, device = "spec:width=1920dp,height=1080dp,dpi=480")
@Composable
fun WelcomeScreenPreview() {
    JetKiteTheme {
        WelcomeScreen()
    }
}
