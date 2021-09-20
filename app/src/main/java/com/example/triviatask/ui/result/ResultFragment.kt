package com.example.triviatask.ui.result

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentResultBinding
import com.example.triviatask.ui.base.BaseFragment

class ResultFragment: BaseFragment<FragmentResultBinding>() {

    val args:ResultFragmentArgs by navArgs()

    override val LOG_TAG: String ="HOME_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_result
    override val viewModel: ResultViewModel by viewModels()

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentResultBinding =DataBindingUtil::inflate

    @SuppressLint("SetTextI18n")
    override fun setUp() {
        binding?.apply {
            this.lifecycleOwner=viewLifecycleOwner
            this.viewModel=this@ResultFragment.viewModel

            score.text = "${args.score}/${args.totulNumOfQuestion}"
        }

    }



}