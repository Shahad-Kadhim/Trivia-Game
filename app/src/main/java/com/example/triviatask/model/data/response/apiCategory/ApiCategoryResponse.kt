package com.example.triviatask.model.data.response.apiCategory


import com.google.gson.annotations.SerializedName

data class ApiCategoryResponse(
    @SerializedName("trivia_categories")
    val triviaCategories: List<TriviaCategory>?
)