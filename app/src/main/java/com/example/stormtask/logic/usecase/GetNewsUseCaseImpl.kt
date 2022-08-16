package com.example.stormtask.logic.usecase

import com.example.stormtask.logic.interfaces.ApiClient
import com.example.stormtask.view.entities.NewsEntity
import com.example.stormtask.view.interfaces.GetNewsUseCase
import javax.inject.Inject

class GetNewsUseCaseImpl @Inject constructor(
    private val apiClient: ApiClient,
): GetNewsUseCase {

    override suspend fun fetchNews(): List<NewsEntity>? {
        return apiClient.getNews()
    }
}