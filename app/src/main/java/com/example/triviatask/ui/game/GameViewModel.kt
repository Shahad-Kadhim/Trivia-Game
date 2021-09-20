package com.example.triviatask.ui.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.model.data.triviaStart.TriviaStartResponse
import com.example.triviatask.model.data.triviaStart.TriviaStartResult
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Constant.LEMON_TAG

class GameViewModel : BaseViewModel() {

    private val questionsList = MutableLiveData<List<TriviaStartResult>?>()

    private val questionIndex = MutableLiveData<Int>()

    private val positionOfQuestion = MutableLiveData(0)

    val scoreOfQuestionEvent = MutableLiveData<Int>()

    val question = Transformations.map(questionIndex) {
        questionsList.value?.get(it)
    }

    fun goToNextQuestion() {

        positionOfQuestion.value = positionOfQuestion.value?.plus(1) // 1+2+3+4....10

        if (questionsList.value!!.size > positionOfQuestion.value!!) {
            positionOfQuestion.value?.let { setQuestion(it) }
        } else {
            scoreOfQuestionEvent.postValue(9)
        }

    }

    fun getQuestion(
        amount: Int,
        category: Int,
        level: String,
        type: String
    ) {
        observe(
            Repository.getQuestion(amount, category, level, type),
            ::onSetQuestionSuccess,
            ::onSetQuestionError
        )

    }

    private fun onSetQuestionSuccess(triviaQuestionResponse: State<TriviaStartResponse>) {

        questionsList.value =
            triviaQuestionResponse.toData()?.results

        Log.i(LEMON_TAG, questionsList.toString())

        positionOfQuestion.value?.let { setQuestion(it) }

    }

    private fun setQuestion(indexOfQuestion: Int) {
        questionIndex.postValue(indexOfQuestion)
    }

    private fun onSetQuestionError(throwable: Throwable) {
        Log.i(LEMON_TAG, "Fail: ${throwable.message}")
    }


}