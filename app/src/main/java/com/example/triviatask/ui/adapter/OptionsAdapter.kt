package com.example.triviatask.ui.adapter

import com.example.triviatask.R


class OptionsAdapter (
    items: List<String>,
    var listener: OptionInteractionListener,
) : BaseAdapter<String>(items,listener) {

    override val layoutId: Int = R.layout.item_options

}



interface OptionInteractionListener: BaseInteractionListener{
    fun onClickOption(option: String)
}