package com.d3if2089.contohpt2.ui.goal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.databinding.ActivityDetailGoalBinding

class DetailGoal : AppCompatActivity() {

    private lateinit var binding: ActivityDetailGoalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGoalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.titleText.text = getString(R.string.detailGoal)
        setSupportActionBar(binding.layoutToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}