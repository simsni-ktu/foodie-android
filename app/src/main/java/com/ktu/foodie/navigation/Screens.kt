package com.ktu.foodie.navigation

sealed class Screens(val route: String){
    data object Main : Screens("main")
    data object Login : Screens("login")
    data object Register : Screens("register")
}