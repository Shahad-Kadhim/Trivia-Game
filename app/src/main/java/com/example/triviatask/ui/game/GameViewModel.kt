package com.example.triviatask.ui.game

import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.model.data.domain.LocalTriviaStart
import com.example.triviatask.model.data.domain.LocalTriviaStartResponse
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Event

class GameViewModel : BaseViewModel(), OptionInteractionListener {

    val questionsList = MutableLiveData<State<LocalTriviaStartResponse>?>()
    val positionOfQuestion = MutableLiveData(0)
    val scoreOfQuestionEvent = MutableLiveData<Event<Int>>()
    val options = MutableLiveData<List<Answer>?>()
    val question = MutableLiveData<LocalTriviaStart?>()
    val isAnswerSelected = MutableLiveData(false)
    private var scores = 0

    fun goToNextQuestion() {
        isAnswerSelected.postValue(false)
        positionOfQuestion.value = positionOfQuestion.value?.plus(1)!!
        if (questionsList.value!!.toData()?.questions?.size ?: 0 > positionOfQuestion.value!!) {
            setQuestion()
        } else {
            scoreOfQuestionEvent.postValue(Event(scores))
        }
    }

    fun getQuestion(
        amount: Int, category: Int?,
        level: String?, type: String?,
    ) =
        apply {
            questionsList.postValue(State.Loading)
            observe(
                Repository.getQuestion(amount, category, level, type),
                ::onSetQuestionSuccess,
                ::onSetQuestionError
            )
        }

    private fun onSetQuestionSuccess(localTriviaQuestionResponse: State<LocalTriviaStartResponse>?) {
        questionsList.value = localTriviaQuestionResponse
        setQuestion()
    }

    private fun onSetQuestionError(throwable: Throwable) {
        questionsList.postValue(State.Error(throwable.message.toString()))
    }

    private fun setQuestion() =
        questionsList.value?.toData()?.questions?.get(positionOfQuestion.value!!)?.let {
            options.postValue(it.answers)
            question.postValue(it)
        }


    override fun onClickOption(option: Answer) {
        isAnswerSelected.postValue(true)
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