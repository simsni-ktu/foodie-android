package com.ktu.foodie.navigation.tabs.restaurant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ktu.foodie.ui.compoonents.Button
import com.ktu.foodie.ui.compoonents.TopBar

@Composable
fun Settings(logout: () -> Unit) {
    Column {
        TopBar()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(title = "Logout", onClick = { logout() })
        }
    }
}