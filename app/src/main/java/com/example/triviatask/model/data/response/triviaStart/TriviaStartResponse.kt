package com.example.triviatask.model.data.response.triviaStart


import com.google.gson.annotations.SerializedName

data class TriviaStartResponse(
    @SerializedName("response_code")
    val responseCode: Int?=null,
    @SerializedName("results")
    val results: List<TriviaStartResult>?=null
)