package com.example.triviatask.ui.game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentGameBinding
import com.example.triviatask.ui.base.BaseFragment

class GameFragment: BaseFragment<FragmentGameBinding>() {

    override val LOG_TAG: String ="HOME_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_game
    override val viewModel :GameViewModel by viewModels()

    override val bindingInflater: (LayoutInflater,Int,ViewGroup?,Boolean) -> FragmentGameBinding =DataBindingUtil::inflate


    override fun setUp() {
        binding?.apply {
            this.lifecycleOwner = viewLifecycleOwner
            this.viewModel = this@GameFragment.viewModel
        }

        setScoreToResultNavigation()
    }

    fun setScoreToResultNavigation() {
        viewModel.scoreOfQuestionEvent.observe(this) {
            Navigation
                .findNavController(binding?.next as View)
                .navigate(
                    GameFragmentDirections
                        .actionGameFragmentToResultFragment(it,10)
                )
        }
    }
}