package com.example.triviatask.ui.setting

import androidx.lifecycle.MutableLiveData
import com.example.triviatask.model.data.domain.GameData
import com.example.triviatask.ui.base.BaseViewModel

class SettingViewModel: BaseViewModel() {

    var gameData = MutableLiveData<List<GameData>>()


}