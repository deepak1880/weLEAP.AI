package com.example.weleapai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weleapai.features.auth.presentation.login.LoginScreen
import com.example.weleapai.features.auth.presentation.onboarding.OnboardingScreen
import com.example.weleapai.features.auth.presentation.signup.SignUpScreen
import com.example.weleapai.features.home.presentation.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MainNavGraph(navController)        }
    }
}

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "onboardingScreen"
    ) {
        composable("onboardingScreen") { OnboardingScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
        composable("login") { LoginScreen(onLoginSuccess = {navController.navigate("homeScreen")}, onSignUpClick = {navController.navigate("signup")}) }
        composable("homeScreen") { HomeScreen(navController) }

    }
}
