package com.example.weleapai.core.bottomNav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.weleapai.core.utils.Screen

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home to Icons.Default.Home,
        Screen.Events to Icons.Default.Event,
        Screen.Profile to Icons.Default.BarChart
    )

    BottomNavigation {
        val currentRoute = navController.currentDestination?.route
        items.forEach { (screen, icon) ->
            BottomNavigationItem(
                icon = { Icon(icon, contentDescription = screen.route) },
                label = { Text(screen.route.replace("Screen", "")) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        restoreState = true
                    }
                }
            )
        }
    }
}