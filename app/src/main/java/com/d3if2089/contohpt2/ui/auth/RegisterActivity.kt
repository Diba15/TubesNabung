package com.d3if2089.contohpt2.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.databinding.ActivityRegisterBinding
import com.d3if2089.contohpt2.ui.WelcomeActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent()
    }

    private fun intent() {
        binding.backIcon.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, WelcomeActivity::class.java))
            finish()
        }
        binding.backText.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, WelcomeActivity::class.java))
            finish()
        }

        binding.tvHaveAccount.setOnClickListener {
            startActivity(
                Intent(
                    this@RegisterActivity,
                    LoginActivity::class.java
                )
            )
            finish()
        }
    }
}