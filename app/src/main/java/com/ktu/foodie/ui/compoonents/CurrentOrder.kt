package com.ktu.foodie.ui.compoonents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ktu.foodie.R
import com.ktu.foodie.ui.theme.foodieDarkGreen
import com.ktu.foodie.ui.theme.foodieGreen
import com.ktu.foodie.ui.theme.foodieLightGreen

@Composable
fun CurrentOrder(allOrders: () -> Unit) {
    var favourite by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Ongoing orders", fontWeight = FontWeight.Bold, color = foodieDarkGreen)
        TextButton(onClick = { allOrders() }) {
            Text("History", color = foodieGreen)
        }
    }
    Column(
        modifier = Modifier
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp))
            .background(color = foodieLightGreen, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_temp_logo),
                contentDescription = "",
                modifier = Modifier.weight(0.2F)
            )
            Column(modifier = Modifier.fillMaxWidth(0.7F)) {
                Text("Order name", color = Color.White, fontWeight = FontWeight.Bold)
                Text("Supermarket", color = Color.White)
            }
            IconButton(modifier = Modifier.weight(0.1F), onClick = { favourite = !favourite }) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    tint = if (favourite) Color.Red else Color.White
                )
            }
        }

    }
}