package com.example.weleapai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weleapai.core.bottomNav.BottomNavigationContainer
import com.example.weleapai.core.drawer.LeftSideDrawer
import com.example.weleapai.features.auth.presentation.login.LoginScreen
import com.example.weleapai.features.auth.presentation.onboarding.OnboardingScreen
import com.example.weleapai.features.auth.presentation.signup.SignUpScreen
import com.example.weleapai.core.utils.Screen
import com.example.weleapai.features.portfolioSelectionProcess.presentation.PersonalDetailsScreen
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()

            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = { LeftSideDrawer(navController, drawerState) }
            ) {
                MainNavGraph(navController, drawerState, scope)
            }
        }
    }
}

@Composable
fun MainNavGraph(
    navController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {
        composable(Screen.Onboarding.route) { OnboardingScreen(navController) }
        composable(Screen.SignUp.route) { SignUpScreen(navController) }
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Screen.Home.route) },
                onSignUpClick = { navController.navigate(Screen.SignUp.route) }
            )
        }
        composable(Screen.Home.route) {
            BottomNavigationContainer(navController, drawerState, scope)
        }
        composable(Screen.PersonalDetails.route) {
            PersonalDetailsScreen(navController)
        }
    }
}

