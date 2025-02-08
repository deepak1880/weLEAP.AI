package com.example.weleapai.core.bottomNav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.weleapai.R
import com.example.weleapai.core.utils.Screen
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.Gray
import com.example.weleapai.ui.theme.White

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    // List of screens with their selected and unselected icons
    val items = listOf(
        Triple(Screen.Home, R.drawable.ic_market_selected, R.drawable.ic_market),
        Triple(Screen.Events, R.drawable.ic_mutualfund_selected, R.drawable.ic_mutualfund),
        Triple(Screen.Profile, R.drawable.ic_profile_selected, R.drawable.ic_profile)
    )

    BottomNavigation(
        backgroundColor = White, // Ensure bottom navigation background is white
        contentColor = DarkBlue // Set content color to match theme
    ) {
        // Get the currently selected route
        val currentRoute = navController.currentDestination?.route

        items.forEach { (screen, selectedIcon, unselectedIcon) ->
            val isSelected = currentRoute == screen.route // Check if the current tab is selected

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = if (isSelected) selectedIcon else unselectedIcon),
                        contentDescription = screen.route,
                        tint = DarkBlue // Tint remains same for consistency
                    )
                },
                label = {
                    Text(
                        screen.route.replace("Screen", ""),
                        color = if (isSelected) DarkBlue else Gray // Change text color based on selection
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true // Avoid multiple instances of the same destination
                        popUpTo(navController.graph.startDestinationId) { saveState = true } // Maintain back stack state
                        restoreState = true // Restore state of previously selected items
                    }
                }
            )
        }
    }
}


