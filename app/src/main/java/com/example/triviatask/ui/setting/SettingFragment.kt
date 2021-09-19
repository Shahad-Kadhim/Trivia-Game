package com.example.triviatask.ui.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentSettingBinding
import com.example.triviatask.model.data.domain.GameData
import com.example.triviatask.ui.adapter.GameAdapter
import com.example.triviatask.ui.adapter.GameInteractionListener
import com.example.triviatask.ui.base.BaseFragment

class SettingFragment: BaseFragment<FragmentSettingBinding>() , GameInteractionListener {

    override val LOG_TAG: String ="SETTING_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_setting
    override val viewModel: SettingViewModel by viewModels()

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSettingBinding =DataBindingUtil::inflate

    override fun setUp() {
        binding?.apply {
            this.lifecycleOwner=viewLifecycleOwner
            this.viewModel=this@SettingFragment.viewModel

            recyclerGame.adapter =  GameAdapter(emptyList() , this@SettingFragment)
        }
    }

    override fun onClickGame(gameData: GameData) {

    }
}