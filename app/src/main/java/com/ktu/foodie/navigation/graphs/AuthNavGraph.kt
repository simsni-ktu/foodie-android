package com.ktu.foodie.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ktu.foodie.navigation.Graph
import com.ktu.foodie.navigation.Screens
import com.ktu.foodie.navigation.screens.auth.Login
import com.ktu.foodie.navigation.screens.auth.Register
import com.ktu.foodie.viewmodels.AuthViewModel

fun NavGraphBuilder.authNavGraph(navController: NavController, authViewModel: AuthViewModel){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screens.Login.route
    ){
        composable(route = Screens.Login.route){
            Login(navController = navController, authViewModel = authViewModel)
        }
        composable(route = Screens.Register.route){
            Register(navController = navController, authViewModel = authViewModel)
        }
    }
}