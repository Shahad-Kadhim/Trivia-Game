package com.example.triviatask.ui.setting

import com.example.triviatask.R
import com.example.triviatask.model.data.domain.GameData
import com.example.triviatask.ui.base.BaseAdapter

class GameAdapter(
    items: List<GameData>,
    var listener: GameInteractionListener,
) : BaseAdapter<GameData>(items,listener) {

    override val layoutId: Int = R.layout.item_game

}