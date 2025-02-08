package com.example.weleapai.core.utils

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboardingScreen")
    object SignUp : Screen("signup")
    object Login : Screen("login")
    object Home : Screen("Home")
    object MutualFund : Screen("Fund")
    object Portfolio : Screen("Portfolio")
    object Profile : Screen("Profile")
    object Analytics : Screen("Analytic")
}
