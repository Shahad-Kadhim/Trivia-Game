package com.example.triviatask.ui


import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.triviatask.ui.base.BaseAdapter


@BindingAdapter(value = ["app:ifWinner"])
fun checkWinner(view: TextView, valueScore: Int){
    when{
        valueScore < 5 -> { view.text = "You Lost" }
         else -> {  view.text = "You Win"  }
    }
}


@BindingAdapter(value = ["app:ifCongrats"])
fun checkCongrats(view: TextView, valueScore: Int){
    when{
        valueScore < 5 -> { view.text = "Hard Luck!" }
        else -> {  view.text = "Congrats!"  }
    }
}


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items:List<T>?) =
    (view.adapter as BaseAdapter<T>?).let {
        if(items != null)
            it?.setItem(items)
        else
            it?.setItem(emptyList())
    }





