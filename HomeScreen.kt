package com.example.sysa

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class) // 🔥 Add this to use experimental APIs
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Sysa - Sync Your Safe Arrival") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to Sysa!", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /* TODO: Add functionality for finding a ride */ }) {
                Text(text = "Find a Ride")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { /* TODO: Add functionality for offering a ride */ }) {
                Text(text = "Offer a Ride")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
