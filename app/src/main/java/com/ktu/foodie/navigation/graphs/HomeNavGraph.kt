package com.ktu.foodie.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ktu.foodie.navigation.Graph
import com.ktu.foodie.navigation.Tabs
import com.ktu.foodie.navigation.tabs.Account
import com.ktu.foodie.navigation.tabs.Discover
import com.ktu.foodie.navigation.tabs.Favorites
import com.ktu.foodie.navigation.tabs.Featured
import com.ktu.foodie.navigation.tabs.Home
import com.ktu.foodie.viewmodels.AuthViewModel

@Composable
fun HomeNavGraph(
    bottomBarNavController: NavHostController,
    rootNavController: NavController,
    modifier: Modifier
) {
    NavHost(
        navController = bottomBarNavController,
        route = Graph.BOTTOM_NAVIGATION,
        startDestination = Tabs.Home.route,
        modifier = modifier
    ) {
        composable(Tabs.Home.route) {
            Home()
        }
        composable(Tabs.Featured.route) {
            Featured()
        }
        composable(Tabs.Discover.route) {
            Discover()
        }
        composable(Tabs.Favorites.route) {
            Favorites()
        }
        composable(Tabs.Account.route) {
            Account(logout = { rootNavController.navigate(Graph.ROOT) })
        }
    }
}