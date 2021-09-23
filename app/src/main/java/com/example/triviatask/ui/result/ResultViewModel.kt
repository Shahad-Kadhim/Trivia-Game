package com.example.triviatask.ui.result

import androidx.lifecycle.MutableLiveData
import com.example.triviatask.ui.base.BaseViewModel
import com.example.triviatask.utils.Event

class ResultViewModel: BaseViewModel() {

    var finalScore = MutableLiveData<Int>()
    var totalNumberScore = MutableLiveData<Int>()
    var liveDataEvent = MutableLiveData<Event<Boolean>>()

    fun setScore(score: Int , totalNumber:Int){
        finalScore.postValue(score)
        totalNumberScore.postValue(totalNumber)
    }

    fun onClickExist(){
        liveDataEvent.postValue(Event(true))
    }

}