package com.example.stormtask.logic.interfaces

import com.example.stormtask.view.entities.NewsEntity

interface ApiClient {
    suspend fun getNews(): List<NewsEntity>?
}