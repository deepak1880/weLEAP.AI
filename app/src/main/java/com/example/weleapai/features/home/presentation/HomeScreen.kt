package com.example.weleapai.features.home.presentation

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {

}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(NavHostController(LocalContext.current))
}
