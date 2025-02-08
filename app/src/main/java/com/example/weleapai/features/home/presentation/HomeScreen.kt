package com.example.weleapai.features.home.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.weleapai.ui.theme.DarkBlue

@Composable
fun HomeScreen(navController: NavHostController) {
    Text(
        text = "HomeScreen",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 45.sp,
        color = DarkBlue
    )
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(NavHostController(LocalContext.current))
}
