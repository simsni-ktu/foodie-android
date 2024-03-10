package com.ktu.foodie.di

import com.ktu.foodie.api.BackendInterface
import com.ktu.foodie.repository.auth.AuthRepository
import com.ktu.foodie.repository.auth.AuthRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.wire.WireJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
        backendInterface: BackendInterface
    ): AuthRepository {
        return AuthRepositoryImpl(backendInterface = backendInterface)
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
                    Moshi.Builder().add(
                        WireJsonAdapterFactory()
                    ).build()
                )
            )
            .baseUrl("http://10.0.2.2:8000")
            .build()
            .create(BackendInterface::class.java)
    }


}