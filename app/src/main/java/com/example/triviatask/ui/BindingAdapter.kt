package com.example.triviatask.ui


import android.widget.TextView
import androidx.databinding.BindingAdapter



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
