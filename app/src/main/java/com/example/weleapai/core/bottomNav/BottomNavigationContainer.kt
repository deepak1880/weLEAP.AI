package com.example.weleapai.core.bottomNav

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.LightBlue


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationContainer(
    navController: NavHostController, drawerState: DrawerState, scope: CoroutineScope
) {
    val bottomNavController = rememberNavController()

    ModalDrawer(
        // Changed to ModalDrawer to customize drawer size
        drawerContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
                    .background(DarkBlue),
                contentAlignment = Alignment.Center
            ) {
                Text("Drawer Content", color = White)
            }
        },
        gesturesEnabled = true,
    ) {
        Scaffold(
            containerColor = White,
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("Home")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Open Drawer")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Handle search action */ }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                        IconButton(onClick = { /* Handle notifications */ }) {
                            Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                        }
                    }
                )
            },
            bottomBar = { BottomNavigationBar(bottomNavController) },
        ) {
            NavHost(
                navController = bottomNavController, startDestination = Screen.Home.route
            ) {
                composable(Screen.Home.route) { HomeScreen(bottomNavController) }
                composable(Screen.MutualFund.route) { MutualFundScreen() }
                composable(Screen.Profile.route) { ProfileScreen() }
                composable(Screen.Analytics.route) { ProfileScreen() }
                composable(Screen.Portfolio.route) { PortFolioScreen() }
            }
        }
    }
}

@Preview
@Composable
private fun BottomNavigationContainerPreview() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    BottomNavigationContainer(navController, drawerState, scope)
}

