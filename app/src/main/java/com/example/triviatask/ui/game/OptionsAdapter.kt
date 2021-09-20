package com.example.triviatask.ui.game

import com.example.triviatask.R
import com.example.triviatask.ui.base.BaseAdapter
import com.example.triviatask.ui.game.OptionInteractionListener


class OptionsAdapter (
    items: List<String>,
    var listener: OptionInteractionListener,
) : BaseAdapter<String>(items,listener) {

    override val layoutId: Int = R.layout.item_option

}



