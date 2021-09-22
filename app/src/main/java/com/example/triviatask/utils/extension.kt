package com.example.triviatask.utils

import android.view.View
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.triviatask.model.data.domain.LocalTriviaStart
import com.example.triviatask.model.data.domain.LocalTriviaStartResponse
import com.example.triviatask.model.data.response.triviaStart.TriviaStartResponse
import com.example.triviatask.model.data.response.triviaStart.TriviaStartResult
import com.example.triviatask.ui.game.Answer
import com.example.triviatask.ui.game.CheckOptions
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.add(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T> Spinner.getSelectedIndex(item: T?): Int {
    for (index in 0 until adapter.count) {
        if (adapter.getItem(index) == item) {
            return index
        }
    }
    return -1
}


fun RadioGroup.getSelectedIndex(): Int {
    for (index in 0 until childCount) {
        if (getChildAt(index).id == checkedRadioButtonId) {
            return index
        }
    }
    return -1
}

fun RadioGroup.setSelectedIndex(index: Int) =
    check(getChildAt(index).id)


fun View.goToFragment(navDir: NavDirections) {
    Navigation.findNavController(this).navigate(navDir)
}

fun TriviaStartResult.convertToLocalTriviaStart(): LocalTriviaStart {
    val allOptions = this.incorrectAnswers?.toMutableList()?.apply {
        correctAnswer?.let { add(it) }
    }?.sortedByDescending { it }?.map {
        Answer(it, CheckOptions.UNSELECTED)
    }
    return LocalTriviaStart(this.question, allOptions, this.type, this.correctAnswer)
}

fun TriviaStartResponse.convertToLocalTriviaStartResponse(): LocalTriviaStartResponse? {
    return this.results?.let { list ->
        LocalTriviaStartResponse(list.map { it.convertToLocalTriviaStart() })
    }
}


