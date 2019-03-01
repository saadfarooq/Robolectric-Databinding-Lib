package com.malvinstn.robolectric.lib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.malvinstn.robolectric.lib.databinding.ActivityLibBinding

class LibActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLibBinding>(this, R.layout.activity_lib)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            binding.content.text.text = "Goodbye World!"
        }
    }

}
