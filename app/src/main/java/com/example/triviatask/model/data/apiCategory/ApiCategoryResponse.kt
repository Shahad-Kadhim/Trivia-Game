package com.example.triviatask.model.data.apiCategory


import com.google.gson.annotations.SerializedName

data class ApiCategoryResponse(
    @SerializedName("trivia_categories")
    val triviaCategories: List<TriviaCategory>?
)