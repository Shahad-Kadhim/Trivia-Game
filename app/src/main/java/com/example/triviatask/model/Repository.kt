package com.example.triviatask.model

import com.example.triviatask.model.network.API
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import com.example.triviatask.utils.convertToLocalTriviaStart
import com.example.triviatask.utils.convertToLocalTriviaStartResponse

object Repository {
    private val api= API.apiService

    fun getQuestion(
        amount:Int,
        category:Int?,
        level:String?,
        type:String?
    ) =
        wrap ( api.getQuestions(amount,category,level,type)).map {
            when(it){
                is State.Error -> State.Error(it.message)
                State.Loading -> State.Loading
                is State.Success -> State.Success(it.toData()?.convertToLocalTriviaStartResponse())
            }
        }

    fun getCategories() =
        wrap(api.getApiCategory())

    fun getCountGlobal() =
        wrap (api.getApiCountGlobal())


    private fun <T>wrap(response: Single<Response<T>>):Observable<State<T>> {
       return response.toObservable().flatMap {
            Observable.create { emitter ->
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