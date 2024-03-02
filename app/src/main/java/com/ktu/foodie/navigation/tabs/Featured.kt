package com.ktu.foodie.navigation.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ktu.foodie.ui.compoonents.TopBar

@Composable
fun Featured(){
    Column(modifier = Modifier.fillMaxSize()){
        TopBar(homeScreen = false)
    }
}