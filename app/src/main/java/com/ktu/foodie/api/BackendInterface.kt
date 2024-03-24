package com.ktu.foodie.api

import com.ktu.foodie.api.models.Message
import com.ktu.foodie.api.models.UserCredentials
import ktu.foodie.proto.User
import retrofit2.http.Body
import retrofit2.http.POST

interface BackendInterface {

    @POST("auth/login")
    suspend fun login(
        @Body userCredentials: UserCredentials
    ): User

    @POST("auth/register")
    suspend fun register(
        @Body userCredentials: UserCredentials
    ): Message
}