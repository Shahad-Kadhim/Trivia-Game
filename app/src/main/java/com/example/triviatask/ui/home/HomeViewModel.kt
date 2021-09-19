package com.example.triviatask.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.OptionsSelected
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.model.data.apiCategory.ApiCategoryResponse
import com.example.triviatask.ui.base.BaseViewModel

class HomeViewModel:BaseViewModel(){

    var categoryGameId = MutableLiveData<String>()
    var questionNumber = MutableLiveData<Int>()
    var difficultyGame = MutableLiveData<String>()
    var gameType = MutableLiveData<String>()


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
//        OptionsSelected(
//            categoryGameId.value,
//            questionNumber.value,
//            difficultyGame.value,
//            gameType.value
//        )

        Log.i("kkkk", categoryGameId.value.toString())
    }


}