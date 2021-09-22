package com.example.triviatask.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentHomeBinding
import com.example.triviatask.ui.base.BaseFragment
import com.example.triviatask.utils.EventObserver
import com.example.triviatask.utils.goToFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>()   {

    override val LOG_TAG: String ="HOME_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) ->
    FragmentHomeBinding =DataBindingUtil::inflate

    override fun setUp() {
        binding?.apply {
            this.lifecycleOwner=viewLifecycleOwner
            this.viewModel=this@HomeFragment.viewModel
        }

        setHomeToGameNavigation()
    }

    private fun setHomeToGameNavigation() {
        viewModel.gameConfigurationEvent.observe(this , EventObserver {
            binding?.startGameBtn?.goToFragment(HomeFragmentDirections.actionHomeFragmentToGameFragment(it))
            Log.i(LOG_TAG , it.toString())
        })
    }

}