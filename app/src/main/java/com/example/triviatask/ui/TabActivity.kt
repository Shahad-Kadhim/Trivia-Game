package com.example.triviatask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.triviatask.R
import com.example.triviatask.databinding.ActivityTabBinding

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