package com.example.stormtask

import com.example.stormtask.data.api.ApiInterface
import com.example.stormtask.data.api.RetrofitClient
import com.example.stormtask.data.entities.NewsApiResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class ApiTest {

    @Mock
    lateinit var mockWebServer: MockWebServer

    @Mock
    lateinit var apiInterface: ApiInterface
    lateinit var gson: Gson

    @Before
    fun setup() {
        gson = GsonBuilder().create()
        mockWebServer = MockWebServer()

        apiInterface = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiInterface::class.java)
    }

    @After
    fun deconstruct() {
        mockWebServer.shutdown()
    }

    @Test
    fun validateUserData_return_success() = runTest {
        val mockResponse = MockResponse()
        mockWebServer.enqueue(
            mockResponse.setBody("{ }")
        )

        val response: Response<NewsApiResponse>? = apiInterface.getNews("", "", "", "")

        assert(response != null)
    }
}