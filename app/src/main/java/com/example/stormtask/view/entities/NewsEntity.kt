package com.example.stormtask.view.entities

import com.google.gson.annotations.SerializedName
import java.util.*

data class NewsEntity(

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("author")
    var author: String,

    @SerializedName("publishedAt")
    var publishedAt: Date,

    @SerializedName("url")
    var url: String,

    @SerializedName("content")
    var content: String,

    @SerializedName("urlToImage")
    var urlToImage: String?
)
