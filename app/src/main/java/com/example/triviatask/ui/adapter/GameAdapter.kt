package com.example.triviatask.ui.adapter

import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentHomeBinding
import com.example.triviatask.model.data.domain.GameData

class GameAdapter(
    items: List<GameData>,
    var listener: GameInteractionListener,
) : BaseAdapter<GameData>(items,listener) {

    override val layoutId: Int = R.layout.item_game

}


interface GameInteractionListener: BaseInteractionListener{
    fun onClickGame(gameData: GameData)
}