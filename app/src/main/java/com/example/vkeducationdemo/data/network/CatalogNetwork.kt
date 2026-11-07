package com.example.vkeducationdemo.data.network

import com.example.vkeducationdemo.domain.repository.CatalogRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

internal object CatalogNetwork {

    private const val BASE_URL = "http://185.103.109.134/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val repository: CatalogRepository =
        CatalogRepositoryImpl(retrofit.create(CatalogApi::class.java))
}
