package com.example.triviatask.ui.game

import com.example.triviatask.R
import com.example.triviatask.model.data.domain.Answer
import com.example.triviatask.ui.base.BaseAdapter


class OptionsAdapter (
    items: List<Answer>,
    var listener: OptionInteractionListener,
) : BaseAdapter<Answer>(items,listener) {

    override val layoutId: Int = R.layout.item_option

}



