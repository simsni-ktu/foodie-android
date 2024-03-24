package com.ktu.foodie.navigation.graphs

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ktu.foodie.navigation.Graph
import com.ktu.foodie.navigation.NavItem
import com.ktu.foodie.navigation.tabs.restaurant.Settings

@Composable
fun RestaurantNavHost(
    bottomBarNavController: NavHostController,
    logout: () -> Unit,
    modifier: Modifier
) {
    NavHost(
        navController = bottomBarNavController,
        route = Graph.CLIENT_NAVIGATION,
        startDestination = NavItem.MysteryBox.route,
        modifier = modifier
    ) {
        composable(NavItem.MysteryBox.route) {
            Column {

            }
        }
        composable(NavItem.Product.route) {
            Column {

            }
        }
        composable(NavItem.Settings.route) {
            Settings(logout = {logout()})
        }
    }
}