package com.example.triviatask.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentResultBinding
import com.example.triviatask.ui.base.BaseFragment
import com.example.triviatask.utils.goToFragment


class ResultFragment: BaseFragment<FragmentResultBinding>() {

    override val LOG_TAG: String ="HOME_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_result
    override val viewModel: ResultViewModel by viewModels()
    val args:ResultFragmentArgs by navArgs()

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean)
    -> FragmentResultBinding =DataBindingUtil::inflate


    override fun setUp() {
        binding?.apply {
            this.lifecycleOwner=viewLifecycleOwner
            this.viewModel=this@ResultFragment.viewModel

            setScores()
            observeEvent()
        }
    }

    private fun observeEvent() {
        viewModel.liveDataEvent.observe(this , {
            binding?.backBtn?.goToFragment(ResultFragmentDirections.actionResultFragmentToHomeFragment())
        })
    }

    private fun setScores() = viewModel.setScore(args.scoreGame)


}

