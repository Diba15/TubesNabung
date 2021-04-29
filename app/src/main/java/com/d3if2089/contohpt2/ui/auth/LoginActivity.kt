package com.d3if2089.contohpt2.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.d3if2089.contohpt2.databinding.ActivityLoginBinding
import com.d3if2089.contohpt2.ui.WelcomeActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent()
    }

    private fun intent() {
        binding.backIcon.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    WelcomeActivity::class.java
                )
            )

            finish()
        }
        binding.backText.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    WelcomeActivity::class.java
                )
            )

            finish()
        }

        binding.tvDontHaveAcc.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    RegisterActivity::class.java
                )
            )
            finish()
        }
    }
}