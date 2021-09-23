package com.example.triviatask.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.Repository
import com.example.triviatask.utils.State
import com.example.triviatask.model.data.domain.Answer
import com.example.triviatask.model.data.domain.CheckOptions
import com.example.triviatask.model.data.domain.LocalTriviaStart
import com.example.triviatask.model.data.domain.LocalTriviaStartResponse
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Event

class GameViewModel : BaseViewModel(), OptionInteractionListener {

    private val _questionsList = MutableLiveData<State<LocalTriviaStartResponse>?>()
    val questionsList:LiveData<State<LocalTriviaStartResponse>?> =_questionsList
    private val _positionOfQuestion = MutableLiveData(0)
    val positionOfQuestion:LiveData<Int> =_positionOfQuestion
    private val _scoreOfQuestionEvent = MutableLiveData<Event<Int>>()
    val scoreOfQuestionEvent :LiveData<Event<Int>> =_scoreOfQuestionEvent
    private val _options = MutableLiveData<List<Answer>?>()
    val options:LiveData<List<Answer>?> =_options
    private val _question = MutableLiveData<LocalTriviaStart?>()
    val question:LiveData<LocalTriviaStart?> =_question
    private val _isAnswerSelected = MutableLiveData(false)
    val isAnswerSelected :LiveData<Boolean> =  _isAnswerSelected
    private var scores = 0

    fun goToNextQuestion() {
        _isAnswerSelected.postValue(false)
        _positionOfQuestion.value = positionOfQuestion.value?.plus(1)!!
        if (_questionsList.value!!.toData()?.questions?.size ?: 0 > positionOfQuestion.value!!) {
            setQuestion()
        } else {
            _scoreOfQuestionEvent.postValue(Event(scores))
        }
    }

    fun getQuestion(
        amount: Int, category: Int?,
        level: String?, type: String?,
    ) =
        apply {
            _questionsList.postValue(State.Loading)
            observe(
                Repository.getQuestion(amount, category, level, type),
                ::onSetQuestionSuccess,
                ::onSetQuestionError
            )
        }

    private fun onSetQuestionSuccess(localTriviaQuestionResponse: State<LocalTriviaStartResponse>?) {
        _questionsList.value = localTriviaQuestionResponse
        setQuestion()
    }

    private fun onSetQuestionError(throwable: Throwable) {
        _questionsList.postValue(State.Error(throwable.message.toString()))
    }

    private fun setQuestion() =
        _questionsList.value?.toData()?.questions?.get(positionOfQuestion.value!!)?.let {
            _options.postValue(it.answers)
            _question.postValue(it)
        }


    override fun onClickOption(option: Answer) {
        _isAnswerSelected.postValue(true)
        _options.value = _options.value?.apply {
            if (option.answer == _question.value?.correctAnswer) {
                option.state = CheckOptions.SELECTED_CORRECT
                scores++
            } else {
                option.state = CheckOptions.SELECTED_INCORRECT
                this.filter { it.answer == _question.value?.correctAnswer }
                    .forEach {
                        it.state = CheckOptions.SELECTED_CORRECT
                    }
            }
        }
    }


}