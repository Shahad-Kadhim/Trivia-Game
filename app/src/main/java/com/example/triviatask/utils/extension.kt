package com.example.triviatask.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.add(compositeDisposable: CompositeDisposable){
    compositeDisposable.add(this)
}


fun View.onClickGoToFragment(navDir: NavDirections) {
    this.setOnClickListener { view ->
        Navigation.findNavController(view).navigate(navDir )
    }
}

fun View.goToFragment(navDir: NavDirections) {
        Navigation.findNavController(this).navigate(navDir )
}
