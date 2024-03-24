package com.ktu.foodie.repository.auth

import com.ktu.foodie.api.Resource
import com.ktu.foodie.api.models.Message
import com.ktu.foodie.api.models.UserCredentials
import kotlinx.coroutines.flow.Flow
import ktu.foodie.proto.User

interface AuthRepository {
    suspend fun login(userCredentials: UserCredentials) : Resource<User>

    suspend fun register(userCredentials: UserCredentials) : Resource<Message>

    fun getUserFromDataStore(): Flow<User>

    suspend fun updateUserStore(user: User?)

}