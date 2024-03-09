package com.ktu.foodie.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ktu.foodie.navigation.Graph
import com.ktu.foodie.navigation.Screens
import com.ktu.foodie.navigation.screens.Login

fun NavGraphBuilder.authNavGraph(navController: NavController){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screens.Login.route
    ){
        composable(route = Screens.Login.route){
            Login(login = {navController.navigate(Graph.BOTTOM_NAVIGATION)})
        }
    }
}