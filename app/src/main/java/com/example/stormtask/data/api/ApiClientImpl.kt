package com.example.stormtask.data.api

import com.example.stormtask.view.entities.NewsEntity
import com.example.stormtask.logic.interfaces.ApiClient
import com.example.stormtask.view.utils.NewsHelper
import javax.inject.Inject

class ApiClientImpl @Inject constructor(
    private val apiInterface: ApiInterface
): ApiClient {

    override suspend fun getNews(): List<NewsEntity>? {

        val response = apiInterface.getNews(
            query = "tesla",
            from = NewsHelper.getCurrentDate(),
            sortBy = "publishedAt",
            apiKey = ApiHelper.API_KEY
        )

        if (response.isSuccessful) {
            return response.body()?.articles
        }

        return null
    }
}