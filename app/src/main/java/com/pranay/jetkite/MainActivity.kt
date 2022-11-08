package com.pranay.jetkite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pranay.jetkite.designsystem.JetKiteTheme
import com.pranay.jetkite.login.LoginScreen
import com.pranay.jetkite.login.utils.LoginState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetKiteTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen(loginState = LoginState.LoginStateOTPCase) {}
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetKiteTheme {
        Greeting("Android")
    }
}
