package com.example.triviatask.model

import com.example.triviatask.model.network.API
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

object Repository {
    private val api= API.apiService

    fun getQuestion(
        amount:Int =10,
        category:Int?=null,
        level:String="easy",
        type:String="multiple"
    ) =
        wrap ( api.getQuestions(amount,category,level,type) )

    fun getCategories() =
        wrap(api.getApiCategory())

    fun getCountGlobal() =
        wrap (api.getApiCountGlobal())


    private fun <T>wrap(response: Single<Response<T>>):Observable<State<T>> {
       return response.toObservable().flatMap {
            Observable.create <State<T>>{ emitter ->
                emitter.onNext(State.Loading)
                if(it.isSuccessful) {
                    emitter.onNext(State.Success(it.body()!!))
                }
                else{
                    emitter.onNext(State.Error(it.message()))
                }
            }
        }
    }
}