package com.ktu.foodie.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ktu.foodie.ui.compoonents.Button
import com.ktu.foodie.ui.compoonents.TopBar

@Composable
fun Login(login: () -> Unit) {
    Column {
        TopBar(homeScreen = false)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(title = "Login", onClick = {login()})
        }
    }
}