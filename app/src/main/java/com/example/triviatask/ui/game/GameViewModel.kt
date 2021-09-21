package com.example.triviatask.ui.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.model.data.response.triviaStart.TriviaStartResponse
import com.example.triviatask.model.data.response.triviaStart.TriviaStartResult
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Constant.LEMON_TAG
import com.example.triviatask.utils.convertToLocalQuestionInfo

class GameViewModel : BaseViewModel(), OptionInteractionListener {

    private val questionsList = MutableLiveData<List<TriviaStartResult>?>()

    val questionIndex = MutableLiveData<Int>()

    val positionOfQuestion = MutableLiveData(0)

    var chooseOptions = ""
    var scores = 0

    val scoreOfQuestionEvent = MutableLiveData<Int>()

    val question = Transformations.map(questionIndex) {
        questionsList.value?.get(it)
    }

    val options = MutableLiveData<List<Answer>?>()
//        Transformations.map(question) {
//        it?.convertToLocalQuestionInfo()?.answers
//    }

    private fun goToNextQuestion() {

        positionOfQuestion.postValue(positionOfQuestion.value?.plus(1)) // 1+2+3+4....10

        if (questionsList.value!!.size > positionOfQuestion.value!!) {
            positionOfQuestion.value?.let { setQuestion(it) }
        } else {
            scoreOfQuestionEvent.postValue(9)
        }

        if (chooseOptions == question.value?.correctAnswer) {

            scores++
        }

    }

    fun getQuestion(
        amount: Int,
        category: Int?,
        level: String?,
        type: String?
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
        options.postValue(
            questionsList.value?.get(indexOfQuestion)?.convertToLocalQuestionInfo()?.answers
        )
        questionIndex.postValue(indexOfQuestion)
    }

    private fun onSetQuestionError(throwable: Throwable) {
        Log.i(LEMON_TAG, "Fail: ${throwable.message}")
    }

    override fun onClickOption(option: Answer) {
        options.value = options.value?.apply {
            forEach {
                if (it.answer == question.value?.correctAnswer) {
                    it.state = CheckOptions.SELECTED_CORRECT
                }else{
                    it.state = CheckOptions.SELECTED_INCORRECT
                }
            }

        }
    }


}