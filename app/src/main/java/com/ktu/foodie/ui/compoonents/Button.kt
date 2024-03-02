package com.ktu.foodie.ui.compoonents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ktu.foodie.ui.theme.foodieGreen

@Composable
fun Button(modifier: Modifier = Modifier, title: String, enabled: Boolean = true, onClick: () -> Unit) {
    androidx.compose.material3.Button(
        onClick = { onClick() },
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = foodieGreen,
            contentColor = Color.White
        )
    ) {
        Text(text = title)
    }
}