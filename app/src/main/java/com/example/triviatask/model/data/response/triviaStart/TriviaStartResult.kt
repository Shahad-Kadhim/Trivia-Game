package com.example.triviatask.model.data.response.triviaStart


import com.google.gson.annotations.SerializedName

data class TriviaStartResult(
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("correct_answer")
    val correctAnswer: String? = null,
    @SerializedName("difficulty")
    val difficulty: String? = null,
    @SerializedName("incorrect_answers")
    val incorrectAnswers: List<String>? = null,
    @SerializedName("question")
    val question: String? = null,
    @SerializedName("type")
    val type: String? = null
) {
//    fun getAllOptions() = incorrectAnswers?.toMutableList()?.apply {
//        correctAnswer?.let { add(it) }
//    }?.shuffled()?.map {
//        Answer(it,CheckOptions.UNSELECTED)
//    }

//    private fun <E> List<E>?.checkedType(): List<E>? {
//
//        return if (type.equals("boolean"))
//            this?.toMutableList()?.sortedBy { it.toString() }
//        else
//            this?.toMutableList()?.shuffled()
//
//    }
}


