package com.example.weleapai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weleapai.features.onboarding.presentation.OnboardingScreen
import com.example.weleapai.features.onboarding.presentation.SignUpScreen
import com.example.weleapai.ui.theme.WeLEAPAITheme

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
        composable("login") { OnboardingScreen(navController) }

    }
}
