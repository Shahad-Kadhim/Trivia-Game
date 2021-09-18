package com.example.triviatask.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentHomeBinding

class HomeFragment:BaseFragment<FragmentHomeBinding>() {

    override val LOG_TAG: String ="HOME_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_home

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentHomeBinding =DataBindingUtil::inflate

    override fun setUp() {

    }

}