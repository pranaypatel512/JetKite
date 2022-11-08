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
import com.pranay.jetkite.components.JetKiteDivider
import com.pranay.jetkite.components.JetKiteLogo
import com.pranay.jetkite.components.JetKiteTextView
import com.pranay.jetkite.components.R
import com.pranay.jetkite.components.TextViewWithEndIcon
import com.pranay.jetkite.components.extension.LightDarkPreview
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
                    .size(height = MaterialTheme.spacing.dp80, width = MaterialTheme.spacing.dp60)
                    .padding(vertical = MaterialTheme.spacing.medium)
            )
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.large))
            JetKiteTextView(text = stringResource(com.pranay.jetkite.login.R.string.welcome_to_jetkite), style = MaterialTheme.typography.displaySmall)
            Spacer(modifier = Modifier.padding(MaterialTheme.spacing.large))
            JetKiteDivider(thickness = MaterialTheme.spacing.dp1)
            TextViewWithEndIcon(
                modifier = Modifier.fillMaxWidth().padding(vertical = MaterialTheme.spacing.large, horizontal = MaterialTheme.spacing.extraSmall),
                text = stringResource(id = R.string.login_to_kite),
                iconRes = JetKiteIcons.Login,
                onOptionClick = onActionLoginClick
            )
            JetKiteDivider(thickness = MaterialTheme.spacing.dp1)
            TextViewWithEndIcon(
                modifier = Modifier.fillMaxWidth().padding(vertical = MaterialTheme.spacing.large, horizontal = MaterialTheme.spacing.extraSmall),
                text = stringResource(id = R.string.open_new_account),
                iconRes = JetKiteIcons.NewAccount,
                onOptionClick = onActionSignUpClick
            )
            JetKiteDivider(thickness = MaterialTheme.spacing.dp1)
        }
    }
}

@LightDarkPreview
@Composable
fun WelcomeScreenPreview() {
    JetKiteTheme {
        WelcomeScreen()
    }
}
