package com.d3if2089.contohpt2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.d3if2089.contohpt2.MainActivity
import com.d3if2089.contohpt2.databinding.ActivityWelcomeBinding
import com.d3if2089.contohpt2.ui.auth.LoginActivity
import com.d3if2089.contohpt2.ui.auth.RegisterActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener { login() }
        binding.registerButton.setOnClickListener { register() }
        binding.skipAccount.setOnClickListener { skip() }
    }

    private fun skip() {
        startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
        finish()
    }

    private fun login() {
        startActivity(Intent(this@WelcomeActivity, LoginActivity::class.java))
    }

    private fun register() {
        startActivity(Intent(this@WelcomeActivity, RegisterActivity::class.java))
    }
}