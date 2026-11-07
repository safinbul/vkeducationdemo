package com.example.vkeducationdemo.data.network

import com.example.vkeducationdemo.domain.model.App
import com.example.vkeducationdemo.domain.model.AppDetails
import com.example.vkeducationdemo.domain.repository.CatalogRepository

internal class CatalogRepositoryImpl(
    private val api: CatalogApi,
) : CatalogRepository {
    override suspend fun getCatalog(): List<App> =
        api.getCatalog().map { it.toApp() }

    override suspend fun getAppDetails(id: String): AppDetails =
        api.getAppDetails(id).toAppDetails()
}
