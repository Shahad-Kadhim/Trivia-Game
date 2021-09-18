package com.example.triviatask.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentHomeBinding
import com.example.triviatask.databinding.FragmentSettingBinding

class SettingFragment:BaseFragment<FragmentSettingBinding>() {

    override val LOG_TAG: String ="SETTING_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_setting

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSettingBinding =DataBindingUtil::inflate

    override fun setUp() {

    }
}