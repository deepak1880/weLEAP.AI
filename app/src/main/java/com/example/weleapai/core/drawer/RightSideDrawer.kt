package com.example.weleapai.core.drawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import com.example.weleapai.core.utils.Screen
import kotlinx.coroutines.launch


@Composable
fun LeftSideDrawer(
    navController: NavHostController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()

    ModalDrawerSheet(
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Menu",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )

        Divider()

        val menuItems = listOf(
            "Market" to Screen.Home.route,
            "My Plans" to Screen.MyPlans.route,
            "Settings" to Screen.Settings.route,
            "Support" to Screen.Support.route,
            "Policies" to Screen.Policies.route
        )

        menuItems.forEach { (title, route) ->
            NavigationDrawerItem(
                label = { Text(text = title) },
                selected = false,
                onClick = {
                    scope.launch { drawerState.close() }
                    navController.navigate(route)
                },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
