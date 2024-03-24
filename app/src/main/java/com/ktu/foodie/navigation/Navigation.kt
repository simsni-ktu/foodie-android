package com.ktu.foodie.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktu.foodie.api.models.Role
import com.ktu.foodie.navigation.graphs.authNavGraph
import com.ktu.foodie.navigation.screens.restaurant.RestaurantMain
import com.ktu.foodie.navigation.screens.user.Main
import com.ktu.foodie.viewmodels.AuthViewModel
import kotlinx.coroutines.flow.first
import ktu.foodie.proto.User

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "authentication_graph"
    const val BOTTOM_NAVIGATION = "tabs_graph"
    const val CLIENT_NAVIGATION = "restaurant_navigation"
}


@Composable
fun Navigation(authViewModel: AuthViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    var startDestination by remember { mutableStateOf<String?>(null) }

    val logout: () -> Unit =
        {
            authViewModel.updateUserStore(user = User());
            navController.navigate(Graph.AUTHENTICATION)
        }

    LaunchedEffect(Unit) {
        val user = authViewModel.getUserFromDataStore().first()
        startDestination = findStartDestination(user)
    }

    startDestination?.let { startDestination ->
        NavHost(
            navController = navController,
            route = Graph.ROOT,
            startDestination = startDestination,
        ) {
            this.authNavGraph(navController = navController, authViewModel = authViewModel)

            composable(route = Graph.BOTTOM_NAVIGATION) {
                Main(logout = { logout() })
//                { id ->
//                    navController.navigate("?sdfsd=$id")
//                }
            }
            composable(route = Graph.CLIENT_NAVIGATION) {
                RestaurantMain(logout = { logout() })
            }

        }
    }

}

fun findStartDestination(user: User): String {
    var destination: String = Graph.AUTHENTICATION
    if (user.email.isNotEmpty() && user.role.equals(Role.USER.name, true)) {
        destination = Graph.BOTTOM_NAVIGATION
    } else if (user.email.isNotEmpty() && (user.role.equals(
            Role.RESTAURANT.name,
            true
        ) || user.role.equals(Role.ADMIN.name, true))
    ) {
        destination = Graph.CLIENT_NAVIGATION
    }
    return destination
}
