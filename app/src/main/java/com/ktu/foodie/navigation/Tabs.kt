package com.ktu.foodie.navigation

import androidx.annotation.DrawableRes
import com.ktu.foodie.R

sealed class Tabs(val title: String, @DrawableRes val icon: Int, val route: String) {

    data object Home : Tabs(title = "Home", icon = R.drawable.ic_home, route = "home")

    data object Featured : Tabs(title = "Featured", icon = R.drawable.ic_star, route = "featured")

    data object Discover : Tabs(title = "Discover", icon = R.drawable.ic_map, route = "discover")

    data object Favorites : Tabs(title = "Favorites", icon = R.drawable.ic_favorites, route = "favorites")

    data object Account : Tabs(title = "Account", icon = R.drawable.ic_account, route = "account")

}