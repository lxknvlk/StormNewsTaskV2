package com.example.stormtask.view.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stormtask.view.entities.NewsEntity
import com.example.stormtask.view.interfaces.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    val newsLiveData = MutableLiveData<List<NewsEntity>>()

    fun getNews(){
        viewModelScope.launch {
            val newsList = getNewsUseCase.fetchNews()
            newsList?.let { newsLiveData.postValue(it) }
        }
    }
}