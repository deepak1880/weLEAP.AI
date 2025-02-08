package com.example.weleapai.core.utils

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboardingScreen")
    object SignUp : Screen("signup")
    object Login : Screen("login")
    object Home : Screen("homeScreen")
    object Events : Screen("eventsScreen")
    object Profile : Screen("profileScreen")
}
