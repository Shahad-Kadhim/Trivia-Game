package com.example.triviatask.model.data.domain

import com.example.triviatask.ui.game.Answer

data class LocalQuestionInfo(
    val question: String?,
    var answers: List<Answer>?,
    val type: String?
)
