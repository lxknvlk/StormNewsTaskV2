package com.example.stormtask

import com.example.stormtask.logic.interfaces.ApiClient
import com.example.stormtask.logic.usecase.GetNewsUseCaseImpl
import com.example.stormtask.view.entities.NewsEntity
import com.example.stormtask.view.interfaces.GetNewsUseCase
import com.example.stormtask.view.ui.MainViewModel
import junit.framework.Assert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class UseCaseTest {

    @Mock
    private lateinit var apiClient: ApiClient

    private lateinit var getNewsUseCase: GetNewsUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        getNewsUseCase = GetNewsUseCaseImpl(apiClient)
    }

    @Test
    fun test() = runTest {
        val newsList: List<NewsEntity> = listOf(
            NewsEntity("", "", "", Date(), "", "", "")
        )

        Mockito.`when`(apiClient.getNews()).thenReturn(newsList)

        Assert.assertEquals(newsList, getNewsUseCase.fetchNews())
    }
}