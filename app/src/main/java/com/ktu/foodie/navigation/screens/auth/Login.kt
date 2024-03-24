package com.ktu.foodie.navigation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ktu.foodie.R
import com.ktu.foodie.navigation.Screens
import com.ktu.foodie.ui.compoonents.Button
import com.ktu.foodie.ui.compoonents.FoodieTextField
import com.ktu.foodie.ui.compoonents.TopBar
import com.ktu.foodie.viewmodels.AuthViewModel

@Composable
fun Login(navController: NavController, authViewModel: AuthViewModel) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        TopBar()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            FoodieTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                placeholder = "Email",
                password = false,
                onValueChange = { email = it })
            Spacer(modifier = Modifier.height(16.dp))
            FoodieTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                placeholder = "Password",
                password = true,
                onValueChange = { password = it })
            Column(
                modifier = Modifier
                    .weight(0.3F)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(id = R.drawable.welcome_logo),
                    contentDescription = null,

                    )
            }
            Button(
                title = "Login",
                modifier = Modifier.fillMaxWidth(),
                loading = authViewModel.loading.value,
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                onClick = {
                    authViewModel.login(
                        email = email,
                        password = password,
                        onSuccess = { destination ->
                            navController.navigate(destination)
                        })

                })
            Spacer(modifier = Modifier.height(8.dp))
            Button(title = "Register", modifier = Modifier.fillMaxWidth(), onClick = {
                navController.navigate(Screens.Register.route)
            })
        }
    }
}

