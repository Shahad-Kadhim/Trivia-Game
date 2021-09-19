package com.example.triviatask.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.triviatask.R
import com.example.triviatask.databinding.FragmentHomeBinding
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.ui.base.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override val LOG_TAG: String ="HOME_FRAGMENT"
    override val layoutId: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentHomeBinding =DataBindingUtil::inflate

    override fun setUp() {
        binding?.apply {
            this.lifecycleOwner=viewLifecycleOwner
            this.viewModel=this@HomeFragment.viewModel
        }
        viewModel.observe(Repository.getCategories(),{
            when (it) {
                is State.Success -> Log.i("TAG", it.toData().toString())
                is State.Loading -> Log.i("TAG","Loading")
                else -> Log.i("TAG","error")
            }

        },{
            Log.i("TAG", it.message.toString())
        })

    }


}