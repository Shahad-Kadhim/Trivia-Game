package com.example.triviatask.model.data.response.apiCategory


import com.google.gson.annotations.SerializedName

data class TriviaCategory(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)