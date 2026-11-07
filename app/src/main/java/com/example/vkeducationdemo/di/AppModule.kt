package com.example.vkeducationdemo.di

import com.example.vkeducationdemo.data.network.CatalogApi
import com.example.vkeducationdemo.data.network.CatalogRepositoryImpl
import com.example.vkeducationdemo.domain.repository.CatalogRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://185.103.109.134/"

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideCatalogApi(retrofit: Retrofit): CatalogApi {
        return retrofit.create(CatalogApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCatalogRepository(impl: CatalogRepositoryImpl): CatalogRepository
}
