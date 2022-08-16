package com.example.stormtask.view.interfaces

import com.example.stormtask.view.entities.NewsEntity

interface GetNewsUseCase {
    suspend fun fetchNews(): List<NewsEntity>?
}