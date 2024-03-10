package com.ktu.foodie.repository.auth

import com.ktu.foodie.api.BackendInterface
import com.ktu.foodie.api.Resource
import com.ktu.foodie.api.models.Message
import com.ktu.foodie.api.models.User
import com.ktu.foodie.api.models.UserCredentials
import retrofit2.HttpException

class AuthRepositoryImpl(private val backendInterface: BackendInterface) : AuthRepository {
    override suspend fun login(userCredentials: UserCredentials): Resource<User> {
        val response = try {
            backendInterface.login(userCredentials = userCredentials)
        } catch (e: Exception) {
//            val a = (e as HttpException).response()?.errorBody()?.string()
            return Resource.Error( "Something went wrong")
        }
        return Resource.Success(response)
    }

    override suspend fun register(userCredentials: UserCredentials): Resource<Message> {
        val response = try {
            backendInterface.register(userCredentials = userCredentials)
        } catch (e: Exception) {
//            val a = (e as HttpException).response()?.errorBody()?.string()
            return Resource.Error( "Something went wrong")
        }
        return Resource.Success(response)
    }
}