package com.example.sysa.ui.splash

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.sysa.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(3000) // Show splash for 3 seconds
        if (navController.currentBackStackEntry?.destination?.route != "login") {
            navController.popBackStack() // Removes splash from backstack
            navController.navigate("login")
        }
    }



    // Logo Scale Animation
    val logoScale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )

    // Text Alpha Animation
    val textAlpha = remember { Animatable(0f) }

    LaunchedEffect(startAnimation) {
        textAlpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1200, easing = LinearEasing)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // SYSA Logo Animation
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher), // Replace with your logo
            contentDescription = "App Logo",
            modifier = Modifier
                .size(150.dp)
                .scale(logoScale)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // "SYSA" Text Animation
        Text(
            text = "SYSA",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5), // Blue color
            modifier = Modifier.alpha(textAlpha.value) // ✅ Use .value
        )

        // "Sync Your Safe Arrival" Text Animation
        Text(
            text = "Sync Your Safe Arrival",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
            modifier = Modifier.alpha(textAlpha.value) // ✅ Use .value
        )
    }
}
