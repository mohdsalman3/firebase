package com.example.library.di

import com.example.library.data.NotificationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):NotificationApiService{
        return retrofit.create(NotificationApiService::class.java)
    }
}