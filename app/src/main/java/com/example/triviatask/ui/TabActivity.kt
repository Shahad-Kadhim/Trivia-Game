package com.example.triviatask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.triviatask.R
import com.example.triviatask.databinding.ActivityTabBinding
import com.example.triviatask.model.Repository
import com.example.triviatask.model.State
import com.example.triviatask.utils.add
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityTabBinding>(
            this,
            R.layout.activity_tab
        ).also { binding ->
            binding.lifecycleOwner=this
        }

    }
}