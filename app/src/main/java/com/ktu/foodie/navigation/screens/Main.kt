package com.ktu.foodie.navigation.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktu.foodie.navigation.Tabs
import com.ktu.foodie.navigation.tabs.Account
import com.ktu.foodie.navigation.tabs.Discover
import com.ktu.foodie.navigation.tabs.Featured
import com.ktu.foodie.ui.theme.foodieGreen

@Composable
fun Main() {

    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                tonalElevation = 8.dp,
                containerColor = foodieGreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
            ) {
                listOf(
                    Tabs.Featured,
                    Tabs.Discover,
                    Tabs.Account
                ).forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            Log.e("item val", item.route)
                            selectedItemIndex = index
                            navController.navigate(item.route)
                        },
                        alwaysShowLabel = false,
                        label = {
                            Text(text = item.title, color = Color.White)
                        },
                        icon = {
                            Icon(painter = painterResource(id = item.icon), null)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedIconColor = Color.White,
                            unselectedTextColor = Color.White,
                            indicatorColor = foodieGreen
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Tabs.Featured.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Tabs.Featured.route) {
                Featured()
            }
            composable(Tabs.Discover.route) {
                Discover()
            }
            composable(Tabs.Account.route) {
                Account()
            }
        }
    }
}