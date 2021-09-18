package com.example.triviatask.model.network

import com.example.triviatask.model.data.triviaStart.TriviaStartResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApiService {

    @GET("api.php")
    suspend fun getStartTrivia(
        @Query("amount") amountKey: String,
        @Query("api_category") categoryKey: String,
        @Query("api_count_global") apiCountGlobal: String,
        @Query("token") token: String,
        @Query("api_category") apiCategory: String,
    ): Response<TriviaStartResponse>

}