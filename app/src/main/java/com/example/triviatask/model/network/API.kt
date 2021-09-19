package com.example.triviatask.model.network

import com.example.triviatask.utils.Constant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private val loginInterceptor = HttpLoggingInterceptor().apply { level=HttpLoggingInterceptor.Level.BODY }
    private val myClient = OkHttpClient.Builder().addInterceptor(loginInterceptor).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(myClient)
        .build()

    val apiService = retrofit.create(TriviaApiService::class.java)
}