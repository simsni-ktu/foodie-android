package com.ktu.foodie.ui.compoonents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ktu.foodie.R
import com.ktu.foodie.ui.theme.foodieDarkGreen
import com.ktu.foodie.ui.theme.foodieLightGreen

@Composable
fun CategoryCard(title: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth(0.4F)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(12.dp))
            .background(color = foodieLightGreen, shape = RoundedCornerShape(12.dp))
            .clickable { }
            .padding(8.dp)
    ) {
        Box {
            Text(
                text = title,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Black,
                color = Color.White
            )

            Image(
                painterResource(id = R.drawable.food),
                contentDescription = null,
                modifier = Modifier
                    .offset(x = 32.dp, y = 16.dp)
                    .padding(start = 4.dp, end = 8.dp)
            )
        }
    }
}
