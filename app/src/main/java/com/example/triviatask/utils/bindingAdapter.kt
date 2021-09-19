package com.example.triviatask.utils

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.triviatask.model.data.apiCategory.TriviaCategory
import androidx.databinding.*


@BindingAdapter(value = ["app:entries"])
fun  setEntries(view: Spinner, entries: List<TriviaCategory>?) {
    if (entries != null) {
        ArrayAdapter(view.context,
            android.R.layout.simple_spinner_dropdown_item, (entries.map { it.name }))
            .also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                view.adapter = it }
    }
}

@BindingAdapter(value = ["app:selectedValue"])
fun selectedItem(view: Spinner, item: String?) {
    if (view.selectedItem?.toString() != item){
        view.setSelection(view.getSelectedIndex(item))
    }
}

@InverseBindingAdapter(attribute = "selectedValue", event = "SpinnerOnItemSelected")
fun captureSelectedValue(view: Spinner): String? {
    return view.selectedItem.toString()
}

@BindingAdapter("SpinnerOnItemSelected")
fun setSelectedListener(view: Spinner, changeListener: InverseBindingListener) {
    view.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            changeListener.onChange()
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }
}



