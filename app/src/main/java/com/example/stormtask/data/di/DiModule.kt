package com.example.stormtask.data.di

import com.example.stormtask.data.api.ApiClientImpl
import com.example.stormtask.data.api.ApiInterface
import com.example.stormtask.data.api.RetrofitClient
import com.example.stormtask.logic.interfaces.ApiClient
import com.example.stormtask.logic.usecase.GetNewsUseCaseImpl
import com.example.stormtask.view.interfaces.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class DiModule {

    @Provides
    fun provideGetNewsUseCase(apiClient: ApiClient): GetNewsUseCase {
        return GetNewsUseCaseImpl(apiClient)
    }

    @Provides
    fun provideApiClient(apiInterface: ApiInterface): ApiClient {
        return ApiClientImpl(apiInterface)
    }

    @Provides
    fun provideRetrofitClient(): Retrofit {
        return RetrofitClient.getInstance()
    }

    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}