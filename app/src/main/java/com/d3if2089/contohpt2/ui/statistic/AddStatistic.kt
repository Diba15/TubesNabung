package com.d3if2089.contohpt2.ui.statistic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.databinding.ActivityAddStatisticBinding

class AddStatistic : AppCompatActivity() {
    private lateinit var binding: ActivityAddStatisticBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.layoutToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.titleText.text = "Add Statistic"
    }
}