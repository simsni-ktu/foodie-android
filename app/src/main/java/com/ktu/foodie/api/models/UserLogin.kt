package com.ktu.foodie.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

enum class Role {
    USER, RESTAURANT, ADMIN
}
@JsonClass(generateAdapter = true)
data class UserCredentials(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)