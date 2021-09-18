package com.example.triviatask.model.data.triviaStart


import com.google.gson.annotations.SerializedName

data class TriviaStartResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val results: List<TriviaStartResult>
)