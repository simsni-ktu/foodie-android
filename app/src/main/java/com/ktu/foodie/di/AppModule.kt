package com.ktu.foodie.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.ktu.foodie.api.BackendInterface
import com.ktu.foodie.repository.auth.AuthRepository
import com.ktu.foodie.repository.auth.AuthRepositoryImpl
import com.ktu.foodie.storage.datastore.UsersSerializer
//import com.ktu.foodie.storage.datastore.UsersSerializer
import com.squareup.moshi.Moshi
import com.squareup.wire.WireJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ktu.foodie.proto.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAuthRepository(
        backendInterface: BackendInterface,
        userStore: DataStore<User>
    ): AuthRepository {
        return AuthRepositoryImpl(backendInterface = backendInterface, userStore = userStore)
    }


    @Singleton
    @Provides
    fun provideApi(): BackendInterface {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(WireJsonAdapterFactory()).build()
                )
            )
            .baseUrl("http://192.168.0.104:8000")  //http://192.168.0.104:8000 physical device //http://10.0.2.2:8000 emulator
            .build()

            .create(BackendInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<User> {
        return DataStoreFactory.create(
            serializer = UsersSerializer
        ){
            appContext.dataStoreFile("user.pb")
        }
    }

}