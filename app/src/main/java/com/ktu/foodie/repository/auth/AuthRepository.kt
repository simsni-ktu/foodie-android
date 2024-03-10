package com.ktu.foodie.repository.auth

import com.ktu.foodie.api.Resource
import com.ktu.foodie.api.models.Message
import com.ktu.foodie.api.models.User
import com.ktu.foodie.api.models.UserCredentials

interface AuthRepository {
    suspend fun login(userCredentials: UserCredentials) : Resource<User>

    suspend fun register(userCredentials: UserCredentials) : Resource<Message>
}