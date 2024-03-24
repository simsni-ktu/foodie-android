package com.ktu.foodie.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ktu.foodie.navigation.Graph
import com.ktu.foodie.navigation.NavItem
import com.ktu.foodie.navigation.tabs.user.Account
import com.ktu.foodie.navigation.tabs.user.Discover
import com.ktu.foodie.navigation.tabs.user.Favorites
import com.ktu.foodie.navigation.tabs.user.Featured
import com.ktu.foodie.navigation.tabs.user.Home

@Composable
fun HomeNavHost(
    bottomBarNavController: NavHostController,
    logout: () -> Unit,
    modifier: Modifier
) {
    NavHost(
        navController = bottomBarNavController,
        route = Graph.BOTTOM_NAVIGATION,
        startDestination = NavItem.Home.route,
        modifier = modifier
    ) {
        composable(NavItem.Home.route) {
            Home()
        }
        composable(NavItem.Featured.route) {
            Featured()
        }
        composable(NavItem.Discover.route) {
            Discover()
        }
        composable(NavItem.Favorites.route) {
            Favorites()
        }
        composable(NavItem.Account.route) {
            Account(logout = { logout() })
        }
    }
}