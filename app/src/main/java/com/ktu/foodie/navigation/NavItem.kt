package com.ktu.foodie.navigation

import androidx.annotation.DrawableRes
import com.ktu.foodie.R

sealed class NavItem(val title: String, @DrawableRes val icon: Int, val route: String) {


    //USER
    data object Home : NavItem(title = "Home", icon = R.drawable.ic_home, route = "home")

    data object Featured : NavItem(title = "Featured", icon = R.drawable.ic_star, route = "featured")

    data object Discover : NavItem(title = "Discover", icon = R.drawable.ic_map, route = "discover")

    data object Favorites : NavItem(title = "Favorites", icon = R.drawable.ic_favorites, route = "favorites")

    data object Account : NavItem(title = "Account", icon = R.drawable.ic_account, route = "account")

    //RESTAURANT
    data object MysteryBox : NavItem("Mystery box", icon = R.drawable.ic_shopping_bag, route = "mystery_box")

    data object Product : NavItem("Products", icon = R.drawable.ic_products, route = "products")

    data object Settings : NavItem("Settings", icon = R.drawable.ic_settings, route = "settings")


}