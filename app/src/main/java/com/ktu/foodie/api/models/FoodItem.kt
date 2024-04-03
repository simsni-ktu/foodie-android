package com.ktu.foodie.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FoodItem(
    @Json(name = "description")
    val description: String,
    @Json(name = "expirationDate")
    val expirationDate: String,
    @Json(name = "itemName")
    val itemName: String,
    @Json(name = "originalPrice")
    val originalPrice: Double,
    @Json(name = "preparationDate")
    val preparationDate: String,
    @Json(name = "price")
    val price: Double,
    @Json(name = "user_id")
    val userId: Int,
    @Json(name = "id")
    val id: Int,
)