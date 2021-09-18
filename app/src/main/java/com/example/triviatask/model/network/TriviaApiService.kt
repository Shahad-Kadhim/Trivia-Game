package com.example.triviatask.model.network

import com.example.triviatask.model.data.apiCategory.ApiCategoryResponse
import com.example.triviatask.model.data.apiCountGlobal.ApiCountGlobalResponse
import com.example.triviatask.model.data.triviaStart.TriviaStartResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApiService {

    @GET("api.php")
    suspend fun getStartTrivia(
        @Query("amount") amountKey: String?,
        @Query("category") categoryKey: String?,
        @Query("difficulty") difficultyKey: String?,
        @Query("type") typeKey: String?,
    ): Response<TriviaStartResponse>

    @GET("api_category.php")
    suspend fun getApiCategory(): Response<ApiCategoryResponse>

    @GET("api_count_global")
    suspend fun getApiCountGlobal(): Response<ApiCountGlobalResponse>
}