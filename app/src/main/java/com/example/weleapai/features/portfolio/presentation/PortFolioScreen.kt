package com.example.weleapai.features.portfolio.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weleapai.ui.theme.DarkBlue

@Composable
fun PortFolioScreen(){
    Text(
        text = "PortFolioScreen",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 45.sp,
        color = DarkBlue
    )
}