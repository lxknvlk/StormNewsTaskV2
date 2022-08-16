package com.example.stormtask.data.entities

import com.example.stormtask.view.entities.NewsEntity
import com.google.gson.annotations.SerializedName

data class NewsApiResponse(
    @SerializedName("status")
    var status: String,

    @SerializedName("totalResults")
    var totalResults: Int,

    @SerializedName("articles")
    var articles: List<NewsEntity>
)
