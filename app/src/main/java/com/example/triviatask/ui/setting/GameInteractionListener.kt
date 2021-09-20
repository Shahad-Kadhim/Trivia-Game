package com.example.triviatask.ui.setting

import com.example.triviatask.model.data.domain.GameData
import com.example.triviatask.ui.base.BaseInteractionListener

interface GameInteractionListener: BaseInteractionListener {
    fun onClickGame(gameData: GameData)
}