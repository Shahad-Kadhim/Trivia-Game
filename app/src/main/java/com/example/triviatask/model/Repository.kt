package com.example.triviatask.model

import com.example.triviatask.model.network.API
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

object Repository {
    private val api= API.apiService

    fun getQuestion(
        amount:Int =10,
        category:Int?=null,
        level:String="easy",
        type:String="multiple"
    ) =
        wrap { api.getStartTrivia(amount,category,level,type) }

    fun getCatergories() =
        wrap { api.getApiCategory() }

    fun getCountGlobal() =
        wrap { api.getApiCountGlobal() }


    private fun <T>wrap(function: () -> Response<T>)=

        Observable.create<State<T>> {emitter->
            emitter.onNext(State.Loading)
            function().apply {
                if(isSuccessful)
                    emitter.onNext(State.Success(body()!!))
                else
                    emitter.onNext(State.Error(message()))
            }
            emitter.onComplete()
        }

}