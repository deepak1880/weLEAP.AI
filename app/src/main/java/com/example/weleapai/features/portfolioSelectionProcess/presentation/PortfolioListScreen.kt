package com.example.weleapai.features.portfolioSelectionProcess.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PortfolioListScreen(selectedSectors: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TableText("Stock", Modifier.weight(2f))
            TableText("Sector", Modifier.weight(1.5f))
            TableText("% Alloc", Modifier.weight(1f))
            TableText("Risk", Modifier.weight(1.5f))
        }

        Divider(color = Color.LightGray, thickness = 1.dp)

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(stockList.filter { selectedSectors.contains(it.sector) }) { stock ->
                StockItemRow(stock)
                Divider(color = Color.LightGray.copy(alpha = 0.5f))
            }
        }
    }
}

@Composable
fun TableText(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun StockItemRow(stock: StockItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Stock Name and Company Name
        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stock.stockName,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = stock.companyName,
                fontSize = 12.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Sector
        Text(
            text = stock.sector,
            fontSize = 12.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1.5f)
        )

        // % Allocation
        Text(
            text = stock.allocation,
            fontSize = 12.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        // Risk Tag
        RiskTag(risk = stock.risk)
    }
}

@Composable
fun RiskTag(risk: String) {
    val backgroundColor = when (risk) {
        "Low Risk" -> Color(0xFF4CAF50) // Green
        "Medium Risk" -> Color(0xFFFFC107) // Yellow
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = risk,
            color = Color.White,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

data class StockItem(
    val stockName: String,
    val companyName: String,
    val sector: String,
    val allocation: String,
    val risk: String
)

val stockList = listOf(
    StockItem("JSWSTEEL", "JSW Steel Ltd.", "Metal", "6.3%", "Medium Risk"),
    StockItem("NATIONALUM", "National Aluminium Company Ltd.", "Metal", "6.3%", "Medium Risk"),
    StockItem("DRREDDY", "Dr. Reddy's Laboratories Ltd.", "Pharma", "6.3%", "Medium Risk"),
    StockItem("SUNPHARMA", "Sun Pharmaceutical Industries Ltd.", "Pharma", "6.3%", "Low Risk"),
    StockItem("MARICO", "Marico Ltd.", "FMCG", "12.5%", "Low Risk"),
    StockItem("RELIANCE", "Reliance Industries Ltd.", "Oil & Gas", "6.3%", "Medium Risk"),
    StockItem("ONGC", "Oil and Natural Gas Corporation Ltd.", "Oil & Gas", "6.3%", "Medium Risk"),
    StockItem("TECHM", "Tech Mahindra Ltd.", "IT", "12.5%", "Medium Risk")
)

@Preview(showBackground = true)
@Composable
fun PortfolioListScreenPreview() {
    PortfolioListScreen(
        selectedSectors = listOf(
            "Metal",
            "Pharma",
            "FMCG",
            "Oil & Gas",
            "IT"
        ) // Example selected sectors
    )
}
