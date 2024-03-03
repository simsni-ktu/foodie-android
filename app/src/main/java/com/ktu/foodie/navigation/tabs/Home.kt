package com.ktu.foodie.navigation.tabs

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.ktu.foodie.ui.compoonents.CategoryCard
import com.ktu.foodie.ui.compoonents.CurrentOrder
import com.ktu.foodie.ui.compoonents.TopBar
import com.ktu.foodie.ui.compoonents.WelcomeCard
import com.ktu.foodie.ui.theme.foodieDarkGreen
import com.ktu.foodie.ui.theme.foodieGreen


@Composable
fun Home() {

    val categories = listOf("Sweets", "Healthy", "Fruits", "Bakery", "Vegetarian", "Dairy", "Dairy", "Dairy")

    Column {
        TopBar(homeScreen = false)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            WelcomeCard(
                username = "Bob",
                title = "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsumlorem ipsum!!"
            )
            Spacer(modifier = Modifier.height(16.dp))
            CurrentOrder(allOrders = {})
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text("Categories", fontWeight = FontWeight.Bold, color = foodieDarkGreen)
            }
            LazyVerticalGrid(
                modifier = Modifier.heightIn(max = 1000.dp),
                contentPadding = PaddingValues(vertical = 16.dp),
                userScrollEnabled = false,
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                content = {
                    items(categories) { category ->
                        CategoryCard(title = category)
                    }
                })
        }
    }
}