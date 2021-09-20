package com.example.triviatask.utils

import android.view.View
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.add(compositeDisposable: CompositeDisposable){
    compositeDisposable.add(this)
}

fun <T> Spinner.getSelectedIndex(item:T?): Int {
    for (index in 0 until adapter.count){
        if(adapter.getItem(index) == item){
            return index
        }
    }
    return -1
}



fun RadioGroup.getSelectedIndex(): Int {
    for (index in 0 until childCount){
        if(getChildAt(index).id == checkedRadioButtonId){
            return index
        }
    }
    return -1
}

fun RadioGroup.setSelectedIndex(index: Int) =
    check(getChildAt(index).id)


fun View.goToFragment(navDir: NavDirections) {
    Navigation.findNavController(this).navigate(navDir )
}


