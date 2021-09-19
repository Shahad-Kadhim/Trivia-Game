package com.example.triviatask.utils

import android.widget.Spinner
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.add(compositeDisposable: CompositeDisposable){
    compositeDisposable.add(this)
}

fun <T> Spinner.getSelectedIndex(item:T?): Int{
    for (index in 0 until this.adapter.count){
        if(this.adapter.getItem(index) == item){
            return index
        }
    }
    return -1
}