package com.example.triviatask.model.network

import com.example.triviatask.model.data.apiCategory.ApiCategoryResponse
import com.example.triviatask.model.data.apiCountGlobal.ApiCountGlobalResponse
import com.example.triviatask.model.data.triviaQuestion.TriviaQuestion
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApiService {

    @GET("api.php")
    fun getStartTrivia(
        @Query("amount") amountKey: String?,
        @Query("category") categoryKey: String?,
        @Query("difficulty") difficultyKey: String?,
        @Query("type") typeKey: String?,
    ): Single<TriviaQuestion>

    @GET("api_category.php")
    fun getApiCategory(): Single<ApiCategoryResponse>

    @GET("api_count_global")
    fun getApiCountGlobal(): Single<ApiCountGlobalResponse>
}