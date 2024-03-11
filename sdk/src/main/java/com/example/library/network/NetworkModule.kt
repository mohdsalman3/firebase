package com.example.library.network

import com.example.library.network.NetworkConfig.Companion.BASE_URL_DEV
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofitInstance():
            Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
        return Retrofit.Builder().baseUrl(BASE_URL_DEV)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}