package com.example.triviatask.ui.result

import androidx.lifecycle.MutableLiveData
import com.example.triviatask.ui.base.BaseViewModel

class ResultViewModel: BaseViewModel() {

    var finalScore = MutableLiveData<Int>()
    var iv = MutableLiveData<Boolean>()


    fun setScore(score: Int){
        finalScore.postValue(score)
    }

    fun onClickExist(){
    }


}