package com.d3if2089.contohpt2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d3if2089.contohpt2.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.skipAccount.setOnClickListener { skip() }
    }

    private fun skip() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}