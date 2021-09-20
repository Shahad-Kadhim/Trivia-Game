package com.example.triviatask.utils

import retrofit2.Retrofit

object Constant {

    const val BASE_URL = "https://opentdb.com/"
    val difficulty = listOf("easy", "medium", "hard")
    val gameType = listOf("boolean","multiple")

    const val LEMON_TAG = "lemon_tag"
    const val SCORE_GAME = "ScoreGame"
}