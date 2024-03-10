package com.ktu.foodie.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ktu.foodie.navigation.Screens
import com.ktu.foodie.ui.compoonents.Button
import com.ktu.foodie.ui.compoonents.FoodieTextField
import com.ktu.foodie.ui.compoonents.TopBar
import com.ktu.foodie.viewmodels.AuthViewModel

@Composable
fun Register(navController: NavController, authViewModel: AuthViewModel){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        TopBar(homeScreen = false)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            FoodieTextField(value = email, placeholder = "email", password = false, onValueChange = {email = it})
            Spacer(modifier = Modifier.height(16.dp))
            FoodieTextField(value = password, placeholder = "password", password = true, onValueChange = {password = it})
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Button(title = "Register", onClick = {
                authViewModel.register(email = email, password = password, onSuccess = {
                    navController.navigate(Screens.Login.route)
                })
            })
        }
    }
}