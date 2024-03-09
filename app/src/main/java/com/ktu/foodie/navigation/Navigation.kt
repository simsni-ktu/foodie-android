package com.ktu.foodie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktu.foodie.navigation.graphs.authNavGraph

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "authentication_graph"
    const val BOTTOM_NAVIGATION = "tabs_graph"
}
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION,
    ) {
        this.authNavGraph(navController = navController)
        composable(route = Graph.BOTTOM_NAVIGATION){
            Main(rootNavController = navController)
        }
    }
}