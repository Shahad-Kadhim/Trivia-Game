package com.example.triviatask.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentResultBinding
import com.example.triviatask.ui.base.BaseFragment
import com.example.triviatask.utils.Constant.SCORE_GAME
import com.example.triviatask.utils.onClickGoToFragment


class ResultFragment: BaseFragment<FragmentResultBinding>() {

    override val LOG_TAG: String ="HOME_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_result
    override val viewModel: ResultViewModel by viewModels()

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean)
    -> FragmentResultBinding =DataBindingUtil::inflate


    override fun setUp() {
        binding?.apply {
            this.lifecycleOwner=viewLifecycleOwner
            this.viewModel=this@ResultFragment.viewModel

            setScores()
        }
    }

    override fun addCallbacks() {

        binding?.apply {
            backBtn.onClickGoToFragment(ResultFragmentDirections.actionResultFragmentToHomeFragment())
        }

    }

    private fun setScores() = viewModel.setScore(Bundle(arguments).getInt(SCORE_GAME))

}

