package com.ktu.foodie.api

import com.ktu.foodie.api.models.FoodItem
import com.ktu.foodie.api.models.FoodPackage
import com.ktu.foodie.api.models.FoodPackagePost
import com.ktu.foodie.api.models.Message
import com.ktu.foodie.api.models.UserCredentials
import ktu.foodie.proto.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BackendInterface {

    @POST("auth/login")
    suspend fun login(
        @Body userCredentials: UserCredentials
    ): User

    @POST("auth/register")
    suspend fun register(
        @Body userCredentials: UserCredentials
    ): Message

    @POST("food-item")
    suspend fun postFoodItem(
        @Body foodItem: FoodItem
    ): FoodItem

    @GET("food-item/{userId}")
    suspend fun getFoodItems(
        @Path("userId") userId: Int
    ): List<FoodItem>
    
    @POST("food-packages")
    suspend fun postFoodPackage(
        @Body foodPackage: FoodPackagePost
    ): FoodPackage
}