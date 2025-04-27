package com.example.weleapai.features.portfolioSelectionProcess.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectorSelectionScreen() {
    val sectors = listOf(
        "Auto",
        "Banking",
        "Energy",
        "FMCG",
        "Healthcare",
        "IT",
        "Pharma",
        "Real Estate",
        "Telecom",
        "Utilities"
    )

    var selectedSectors by remember { mutableStateOf(setOf<String>()) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text(
                text = "Select Sectors",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Choose the sectors you are interested in.",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                content = {
                    items(sectors) { sector ->
                        SectorItem(sector = sector,
                            isSelected = selectedSectors.contains(sector),
                            onClick = {
                                selectedSectors = if (selectedSectors.contains(sector)) {
                                    selectedSectors - sector
                                } else {
                                    selectedSectors + sector
                                }
                            })
                    }
                })

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val selected = selectedSectors.joinToString(",")
                    // navController.navigate("next_screen_route?selectedSectors=$selected")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
            ) {
                Text(
                    text = "Continue", fontSize = 16.sp, color = Color.White
                )
            }
        }
    }
}

@Composable
fun SectorItem(
    sector: String, isSelected: Boolean, onClick: () -> Unit
) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .background(
            color = if (isSelected) Color(0xFF2563EB) else Color(0xFFF5F5F5),
            shape = RoundedCornerShape(20.dp)
        )
        .border(
            width = 1.dp,
            color = if (isSelected) Color(0xFF2563EB) else Color.LightGray,
            shape = RoundedCornerShape(20.dp)
        )
        .padding(horizontal = 16.dp, vertical = 10.dp)
        .clickable { onClick() }) {
        Text(
            text = sector,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun PreviewSectorSelectionScreen() {
    SectorSelectionScreen()
}

