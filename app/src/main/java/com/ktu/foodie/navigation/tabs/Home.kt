package com.ktu.foodie.navigation.tabs

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktu.foodie.ui.compoonents.Button
import com.ktu.foodie.ui.compoonents.CurrentOrder
import com.ktu.foodie.ui.compoonents.TopBar
import com.ktu.foodie.ui.compoonents.WelcomeCard
import com.ktu.foodie.ui.theme.foodieGreen

@Composable
fun Home(){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp, top = 24.dp)){
     TopBar(homeScreen = true)
        Spacer(modifier = Modifier.height(24.dp))
        WelcomeCard(username = "Bob", title = "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum!")
        Spacer(modifier = Modifier.height(16.dp))
        CurrentOrder(allOrders = {})
    }
}