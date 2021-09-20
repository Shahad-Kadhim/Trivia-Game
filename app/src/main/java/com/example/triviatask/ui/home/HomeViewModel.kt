package com.example.triviatask.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.OptionsSelected
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.model.data.apiCategory.ApiCategoryResponse
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Constant

class HomeViewModel:BaseViewModel(){

    val gameCategory = MutableLiveData<String>()
    val difficultyGame = MutableLiveData(0)
    val gameType = MutableLiveData(0)
    val questionNumber = MutableLiveData(1)


    private val _categoryList = MutableLiveData<ApiCategoryResponse>()
    val categoryList: LiveData<ApiCategoryResponse>
        get() = _categoryList


    init {
        getAllCategories()
    }

    private fun getAllCategories(){
        observe(Repository.getCategories(),::onGetCategorySuccess, ::onGetCategoryError )
    }

    private fun onGetCategorySuccess(apiCategoryResponse: State<ApiCategoryResponse>){
        _categoryList.postValue(apiCategoryResponse.toData()) }

    private fun onGetCategoryError(throwable: Throwable){}


    fun onClickStartGame(){
        OptionsSelected(
            getCategoryId(),
            questionNumber.value,
            Constant.difficulty[difficultyGame.value!!],
            Constant.gameType[gameType.value!!]
        )
    }

    private fun getCategoryId(): Int? {
        return categoryList.value?.triviaCategories?.filter {
            it.name == gameCategory.value }?.map { it.id }?.first()
    }
}