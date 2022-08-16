package com.example.stormtask.view.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object NewsHelper {
    const val KEY_TITLE = "KEY_TITLE"
    const val KEY_DESCRIPTION = "KEY_DESCRIPTION"
    const val KEY_IMAGE_URL = "KEY_IMAGE_URL"
    const val KEY_CONTENT = "KEY_CONTENT"
    const val KEY_AUTHOR = "KEY_AUTHOR"
    const val KEY_PUBLISH_DATE = "KEY_PUBLISH_DATE"
    const val KEY_NEWS_ID = "KEY_NEWS_ID"
    const val KEY_NEWS_OBJECT = "KEY_NEWS_OBJECT"
    const val KEY_URL = "KEY_URL"


    @SuppressLint("SimpleDateFormat")
    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-M-dd")
        return dateFormat.format(Date())
    }
}

