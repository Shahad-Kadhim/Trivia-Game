package com.example.triviatask.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.Repository
import com.example.triviatask.model.GameConfiguration
import com.example.triviatask.model.State
import com.example.triviatask.model.data.response.apiCategory.ApiCategoryResponse
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Constant
import com.example.triviatask.utils.Event

class HomeViewModel:BaseViewModel(){

    val gameCategory = MutableLiveData<String>()
    val difficultyGame = MutableLiveData(DEFAULT_NUMBER_RADIO)
    val gameType = MutableLiveData(DEFAULT_NUMBER_RADIO)
    val questionNumber = MutableLiveData(DEFAULT_NUMBER_OF_QUESTION)
    val gameConfigurationEvent = MutableLiveData<Event<GameConfiguration>>()

    private val _categoryList = MutableLiveData<State<ApiCategoryResponse>>()
    val categoryList: LiveData<State<ApiCategoryResponse>>
        get() = _categoryList

    init {
        getAllCategories()
    }

    private fun getAllCategories(){
        _categoryList.postValue(State.Loading)
        observe(Repository.getCategories(),::onGetCategorySuccess, ::onGetCategoryError )
    }

    private fun onGetCategorySuccess(apiCategoryResponse: State<ApiCategoryResponse>){
        _categoryList.postValue(apiCategoryResponse)
    }

    private fun onGetCategoryError(throwable: Throwable){
        _categoryList.postValue(State.Error(throwable.message.toString()))
    }


    fun onClickStartGame(){
        gameConfigurationEvent.postValue(
           Event(
               GameConfiguration(
                   getCategoryId() ?: GENERAL_KNOWLEDGE_ID,
                   questionNumber.value ?: DEFAULT_NUMBER_OF_QUESTION,
                   Constant.difficulty[difficultyGame.value!!],
                   Constant.gameType[gameType.value!!]
               )
           )

        )
    }

    private fun getCategoryId(): Int? {
        return categoryList.value?.toData()?.triviaCategories?.filter {
            it.name == gameCategory.value }?.map { it.id }?.first()
    }

    companion object{
        const val GENERAL_KNOWLEDGE_ID = 9
        const val DEFAULT_NUMBER_OF_QUESTION = 5
        const val DEFAULT_NUMBER_RADIO = 0
    }

}