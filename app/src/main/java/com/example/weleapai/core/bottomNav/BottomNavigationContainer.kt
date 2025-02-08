package com.example.weleapai.core.bottomNav

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weleapai.features.home.presentation.HomeScreen
import com.example.weleapai.features.mutualfund.presentation.MutualFundScreen
import com.example.weleapai.features.profile.presentation.ProfileScreen
import com.example.weleapai.core.utils.Screen
import com.example.weleapai.features.portfolio.presentation.PortFolioScreen
import com.example.weleapai.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationContainer(navController: NavHostController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        containerColor = White,
        bottomBar = { BottomNavigationBar(bottomNavController) },
    ) {
        NavHost(
            navController = bottomNavController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) { HomeScreen(bottomNavController) }
            composable(Screen.MutualFund.route) { MutualFundScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
            composable(Screen.Analytics.route) { ProfileScreen() }
            composable(Screen.Portfolio.route) { PortFolioScreen() }

        }
    }
}

