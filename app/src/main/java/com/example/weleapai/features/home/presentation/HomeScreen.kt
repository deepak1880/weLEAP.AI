package com.example.weleapai.features.home.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.White

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 50.dp, start = 16.dp, end = 16.dp, bottom = 50.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Indices",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { /* Handle click */ }
            ) {
                Text(
                    text = "View All",
                    color = DarkBlue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    tint = DarkBlue
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))


        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(3.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "NIFTY",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = Color.Black,
                        )
                        Text(
                            text = "23,559.95 (-43.40)",
                            color = Color.Red,
                            fontSize = 16.sp,
                            lineHeight = 25.sp,
                        )
                        Text(
                            text = "07 Feb 2025",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.ShowChart,
                        contentDescription = "Chart",
                        modifier = Modifier.size(60.dp),
                        tint = DarkBlue
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .offset(y = (-4).dp)
                ) {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 2f,
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(10f, 10f),
                            0f
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "SENSEX",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = Color.Black,
                        )
                        Text(
                            text = "-470.39 Cr.",
                            color = Color.Red,
                            fontSize = 16.sp,
                            lineHeight = 25.sp
                        )
                        Text(
                            text = "07 Feb 2025",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.BarChart,
                        contentDescription = "FII Chart",
                        modifier = Modifier.size(60.dp),
                        tint = DarkBlue
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val icons = listOf(
            Pair(Icons.Default.Brush, "Indices"),
            Pair(Icons.Default.Search, "Trending\nStocks"),
            Pair(Icons.Default.Article, "News &\nUpdates"),
            Pair(Icons.Default.Handshake, "Deals"),
            Pair(Icons.Default.Brush, "Indices"),
            Pair(Icons.Default.Search, "Trending\nStocks"),
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(icons) { (icon, title) ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { /* Handle Click */ }
                ) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .shadow(3.dp, CircleShape)
                            .background(White, shape = CircleShape)
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = title,
                            modifier = Modifier.size(35.dp),
                            tint = DarkBlue
                        )
                    }
                    Text(
                        text = title,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .width(80.dp)
                            .padding(top = 5.dp),
                        lineHeight = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                }
            }
        }

        Text(
            modifier = Modifier.padding(top = 15.dp, start = 10.dp),
            text = "Smart Investment Feature",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        val features = listOf(
            Feature(
                title = "AI-Powered Recommendations",
                description = "Our advanced AI analyzes market trends to suggest optimal investment options based on your preferences.",
                icon = Icons.Default.BarChart
            ), Feature(
                title = "Risk Assessment",
                description = "Customize your risk tolerance and let our system design a portfolio that matches your comfort level.",
                icon = Icons.Default.Shield
            ), Feature(
                title = "Sector Allocation",
                description = "Diversify your investments across sectors like Metal, Pharma, FMCG, and Oil with personalized allocation.",
                icon = Icons.Default.PieChart
            ), Feature(
                title = "Performance Tracking",
                description = "Monitor your portfolio's performance with intuitive visualizations and real-time updates.",
                icon = Icons.Default.ShowChart
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            features.forEach { feature ->
                FeatureCard(feature = feature)
                Spacer(modifier = Modifier.height(2.dp))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        InvestmentJourneyScreen()

        Spacer(modifier = Modifier.height(10.dp))

    }

}

@Preview()
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(NavHostController(LocalContext.current))
}
