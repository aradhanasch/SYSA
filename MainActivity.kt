package com.example.sysa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sysa.ui.auth.LoginScreen
import com.example.sysa.ui.auth.SignUpScreen
import com.example.sysa.ui.theme.SYSATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SYSATheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                var showSignUp by remember { mutableStateOf(false) } // ✅ Declare showSignUp state

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (isLoggedIn) {
                        Greeting(
                            name = "User", // Replace with actual user name after authentication
                            modifier = Modifier.padding(innerPadding)
                        )
                    } else {
                        if (showSignUp) {
                            SignUpScreen(
                                onSignUpSuccess = {
                                    isLoggedIn = true // Simulate successful sign-up
                                    showSignUp = false
                                },
                                onBackToLogin = { showSignUp = false } // ✅ Go back to Login
                            )
                        } else {
                            LoginScreen(
                                onLogin = { email, password ->
                                    isLoggedIn = true // Simulate successful login
                                },
                                onNavigateToSignUp = { showSignUp = true } // ✅ Switch to Sign-Up
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SYSATheme {
        Greeting("Android")
    }
}
