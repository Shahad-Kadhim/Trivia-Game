package com.example.triviatask.ui.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.model.data.domain.LocalTriviaStart
import com.example.triviatask.model.data.domain.LocalTriviaStartResponse
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Constant.LEMON_TAG

class GameViewModel : BaseViewModel(), OptionInteractionListener {

    private val questionsList = MutableLiveData<List<LocalTriviaStart>?>()
    val positionOfQuestion = MutableLiveData(0)
    val scoreOfQuestionEvent = MutableLiveData<Int>()
    val options = MutableLiveData<List<Answer>?>( )
    val question =  MutableLiveData<LocalTriviaStart?>()
    private var scores = 0


    fun goToNextQuestion() {
        positionOfQuestion.value = positionOfQuestion.value?.plus(1)!!
        if ( questionsList.value!!.size > positionOfQuestion.value!!) {
               setQuestion()
        } else {
               scoreOfQuestionEvent.postValue(scores)
        }
    }

    fun getQuestion(amount: Int, category: Int?,
                    level: String?, type: String?, ) =
        observe(
            Repository.getQuestion(amount, category, level, type),
            ::onSetQuestionSuccess,
            ::onSetQuestionError
        )

    private fun onSetQuestionSuccess(localTriviaQuestionResponse: State<LocalTriviaStartResponse?>) {
        questionsList.value = localTriviaQuestionResponse.toData()?.questions
        setQuestion()
    }

    private fun setQuestion() =
        questionsList.value?.get(positionOfQuestion.value!!)?.let {
            options.postValue(it.answers)
            question.postValue(it)
        }

    private fun onSetQuestionError(throwable: Throwable) {
        Log.i(LEMON_TAG, "Fail: ${throwable.message}")
    }

    override fun onClickOption(option: Answer) {
        options.value = options.value?.apply {
            if (option.answer == question.value?.correctAnswer) {
                option.state = CheckOptions.SELECTED_CORRECT
                scores++
            } else {
                option.state = CheckOptions.SELECTED_INCORRECT
                this.filter { it.answer == question.value?.correctAnswer }
                    .forEach {
                        it.state = CheckOptions.SELECTED_CORRECT
                    }
            }
        }
    }


}