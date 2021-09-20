package com.example.triviatask.ui.game

import com.example.triviatask.ui.base.BaseInteractionListener

interface OptionInteractionListener: BaseInteractionListener {
    fun onClickOption(option: String)
}