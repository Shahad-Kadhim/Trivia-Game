package com.example.triviatask.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentHomeBinding
import com.example.triviatask.model.data.domain.GameData
import com.example.triviatask.ui.adapter.GameAdapter
import com.example.triviatask.ui.adapter.GameInteractionListener
import com.example.triviatask.ui.base.BaseFragment
import com.example.triviatask.utils.goToFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>()  {

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
    }



}