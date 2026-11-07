package com.example.vkeducationdemo.domain.repository

import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.domain.model.AppDetails

interface CatalogRepository {
    suspend fun getCatalog(): List<App>
    suspend fun getAppDetails(id: String): AppDetails
}
