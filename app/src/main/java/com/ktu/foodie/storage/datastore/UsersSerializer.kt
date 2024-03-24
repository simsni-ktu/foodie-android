package com.ktu.foodie.storage.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import ktu.foodie.proto.User
import java.io.InputStream
import java.io.OutputStream

object UsersSerializer: Serializer<User> {
    override val defaultValue: User = User()

    override suspend fun readFrom(input: InputStream): User {
        try{
            return User.ADAPTER.decode(input)
        } catch (exception: Exception){
            throw CorruptionException("Cannot read data", exception)
        }
    }

    override suspend fun writeTo(t: User, output: OutputStream)  = User.ADAPTER.encode(output, t)


}