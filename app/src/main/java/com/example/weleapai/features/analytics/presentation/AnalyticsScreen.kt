package com.example.weleapai.features.analytics.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weleapai.ui.theme.DarkBlue

@Composable
fun AnalyticsScreen() {
    Text(
        text = "AnalyticsScreen",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 45.sp,
        color = DarkBlue
    )
}