package com.example.triviatask.model.data.domain

data class LocalTriviaStart(
    val question: String?,
    var answers: List<Answer>?,
    val type: String?,
    val correctAnswer: String?
)
