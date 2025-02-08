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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationContainer(navController: NavHostController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavController) }
    ) {
        NavHost(
            navController = bottomNavController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) { HomeScreen(bottomNavController) }
            composable(Screen.Events.route) { MutualFundScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}

