package com.example.triviatask.utils

import android.widget.Button
import androidx.navigation.Navigation
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.add(compositeDisposable: CompositeDisposable){
    compositeDisposable.add(this)
}

fun Button.onClickGoToFragment(layoutId: Int) {
    this.setOnClickListener { view ->
        Navigation.findNavController(view).navigate(layoutId )
    }
}
