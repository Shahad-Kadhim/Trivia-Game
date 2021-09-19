package com.example.triviatask.ui.game

import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.data.domain.GameData
import com.example.triviatask.ui.base.BaseViewModel

class GameViewModel:BaseViewModel() {

    var gameData = MutableLiveData<List<GameData>>()

}