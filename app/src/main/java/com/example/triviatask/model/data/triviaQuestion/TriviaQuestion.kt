package com.example.triviatask.model.data.triviaQuestion


import com.google.gson.annotations.SerializedName

data class TriviaQuestion(
    @SerializedName("response_code")
    val responseCode: Int?,
    @SerializedName("results")
    val results: List<ResultQuestion>?
)