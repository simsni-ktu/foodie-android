package com.ktu.foodie.navigation

import androidx.annotation.DrawableRes
import com.ktu.foodie.R

sealed class Tabs(val title: String, @DrawableRes val icon: Int, val route: String) {
    data object Featured : Tabs(title = "Featured", icon = R.drawable.ic_star, route = "featured")

    data object Discover : Tabs(title = "Discover", icon = R.drawable.ic_map, route = "discover")

    data object Account : Tabs(title = "Account", icon = R.drawable.ic_account, route = "account")

}