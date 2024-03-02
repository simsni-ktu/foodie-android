package com.ktu.foodie.ui.compoonents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktu.foodie.R
import com.ktu.foodie.ui.theme.foodieGreen

@Composable
fun TopBar(homeScreen: Boolean){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(64.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = R.drawable.foodie_logo), contentDescription = null,)
        if(homeScreen) {
            Text("Foodie", fontWeight = FontWeight.Bold, color = foodieGreen, fontSize = 24.sp)
        }
    }
}