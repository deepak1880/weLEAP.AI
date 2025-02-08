package com.example.weleapai.core.bottomNav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.weleapai.R
import com.example.weleapai.core.utils.Screen
import com.example.weleapai.ui.theme.DarkBlue
import com.example.weleapai.ui.theme.White

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Triple(Screen.Home, R.drawable.ic_market_selected, R.drawable.ic_market),
        Triple(Screen.Portfolio, R.drawable.ic_portfolio_selected, R.drawable.ic_portfolio),
        Triple(Screen.Analytics, R.drawable.ic_analytic_selected, R.drawable.ic_analytic),
        Triple(Screen.MutualFund, R.drawable.ic_mutualfund_selected, R.drawable.ic_mutualfund),
        Triple(Screen.Profile, R.drawable.ic_profile_selected, R.drawable.ic_profile)
    )

    BottomNavigation(
        backgroundColor = White,
        contentColor = DarkBlue
    ) {
        val currentRoute = navController.currentDestination?.route

        items.forEach { (screen, selectedIcon, unselectedIcon) ->
            val isSelected = currentRoute == screen.route

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = if (isSelected) selectedIcon else unselectedIcon),
                        contentDescription = screen.route,
                        tint = if (isSelected) DarkBlue else DarkBlue
                    )
                },
                label = {
                    Text(
                        screen.route.replace("Screen", ""),
                        color = if (isSelected) DarkBlue else DarkBlue
                    )
                },
                selected = isSelected,
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

@Preview
@Composable
private fun BottomNavigationBarPreviwe() {
    BottomNavigationBar(
        NavHostController(LocalContext.current)
    )
}
