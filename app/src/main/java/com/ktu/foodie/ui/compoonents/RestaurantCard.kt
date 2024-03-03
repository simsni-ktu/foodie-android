package com.ktu.foodie.ui.compoonents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ktu.foodie.R
import com.ktu.foodie.ui.theme.foodieDarkGreen
import com.ktu.foodie.ui.theme.foodieGreen

@Composable
fun RestaurantCard() {

    var isFavorite by remember { mutableStateOf(false) }
    val cardHeight = LocalConfiguration.current.screenHeightDp / 6

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight.dp)
            .shadow(elevation = 16.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(foodieGreen)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.food),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = { isFavorite = !isFavorite },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp, end = 8.dp)
                        .background(color = Color.White, shape = CircleShape)
                        .size(32.dp)
                ) {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null,
                        tint = if (isFavorite) Color.Red else Color.LightGray,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Restaurant", fontWeight = FontWeight.SemiBold, color = foodieDarkGreen, modifier = Modifier.weight(0.4F))
                    Row(modifier = Modifier.weight(0.6F),horizontalArrangement = Arrangement.Start) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_work_hours),
                            contentDescription = "",
                            tint = foodieDarkGreen
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = foodieDarkGreen
                                )
                            ) {
                                append("Hours: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Normal,
                                    color = foodieDarkGreen
                                )
                            ) {
                                append("18:15 - 19:15")
                            }
                        })

                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(0.4F)) {
                        Box {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_star),
                                modifier = Modifier.size(32.dp),
                                contentDescription = "",
                                tint = Color(0XFFE99858)
                            )
                            Text(
                                "5",
                                fontSize = 11.sp,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "3.99$",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 13.sp,
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(16.dp),
                                    color = foodieDarkGreen
                                )
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }
                    Row(modifier = Modifier.weight(0.6F), horizontalArrangement = Arrangement.Start) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location_target),
                            contentDescription = "",
                            tint = foodieDarkGreen
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("0.3 Km away!", color = foodieDarkGreen, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}