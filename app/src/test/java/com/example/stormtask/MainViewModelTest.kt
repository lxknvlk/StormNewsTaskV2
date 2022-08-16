package com.example.stormtask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.stormtask.view.entities.NewsEntity
import com.example.stormtask.view.interfaces.GetNewsUseCase
import com.example.stormtask.view.ui.MainViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class MainViewModelTest {

    @Mock
    private lateinit var getNewsUseCase: GetNewsUseCase

    @Mock
    private lateinit var newsObserver: Observer<List<NewsEntity>>
    private lateinit var viewModel: MainViewModel

    private val dispatcher = StandardTestDispatcher()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)

        viewModel = MainViewModel(getNewsUseCase)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testLiveData() = runTest {
        val newsList: List<NewsEntity> = listOf(
            NewsEntity("", "", "", Date(), "", "", "")
        )

        Mockito.`when`(getNewsUseCase.fetchNews()).thenReturn(newsList)

        viewModel.getNews()
        advanceUntilIdle()

        assertEquals(newsList, viewModel.newsLiveData.value)
    }
}