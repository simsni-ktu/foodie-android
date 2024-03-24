package com.ktu.foodie.navigation.screens.restaurant

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ktu.foodie.navigation.NavItem
import com.ktu.foodie.navigation.graphs.RestaurantNavHost
import com.ktu.foodie.ui.theme.foodieGreen

@Composable
fun RestaurantMain(logout: () -> Unit) {

    val bottomBarNavController = rememberNavController()
    val tabs = listOf(NavItem.MysteryBox, NavItem.Product, NavItem.Settings)

    fun onTabChange(destination: String) {
        bottomBarNavController.navigate(destination) {
            popUpTo(bottomBarNavController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    Scaffold(
        bottomBar = {
            RestaurantBottomBar(
                bottomBarNavController = bottomBarNavController,
                tabs = tabs,
                onTabChange = { onTabChange(it) })
        }
    ) { paddingValues ->
        RestaurantNavHost(
            bottomBarNavController = bottomBarNavController,
            logout = logout,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun RestaurantBottomBar(
    bottomBarNavController: NavController,
    tabs: List<NavItem>,
    onTabChange: (String) -> Unit
) {
    val navBackStackEntry by bottomBarNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        tonalElevation = 8.dp,
        containerColor = foodieGreen,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
    ) {
        tabs.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    onTabChange(item.route)
                },
                alwaysShowLabel = false,
                label = {
                    Text(text = item.title, color = Color.White)
                },
                icon = {
                    Icon(painter = painterResource(id = item.icon), null)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = foodieGreen
                )
            )
        }
    }
}