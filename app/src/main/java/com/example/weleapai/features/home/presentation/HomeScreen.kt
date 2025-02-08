package com.example.weleapai.features.home.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Text(
        text = "Home Page",
    )
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(NavHostController(LocalContext.current))
}
