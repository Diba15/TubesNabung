package com.d3if2089.contohpt2.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.d3if2089.contohpt2.Config
import com.d3if2089.contohpt2.MainActivity
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.databinding.ActivityRegisterBinding
import com.d3if2089.contohpt2.ui.WelcomeActivity
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registBtn.setOnClickListener {
            registerSystem()
        }
        intent()
    }

    private fun registerSystem() {
        val url = Config.register
        val name = binding.nameEditText.text
        val username = binding.usernameEditText.text
        val password = binding.passwordEditText.text

        val stringRequest = object : StringRequest(
            Method.POST, url,
            { response ->
                val jsonObject = JSONObject(response)
                val success = jsonObject.getString("success")

                if (success.equals("1")) {
                    Toast.makeText(this, "Silahkan Login", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, WelcomeActivity::class.java))
                    finish()
                }
            }, {
                Toast.makeText(this, "Register Error", Toast.LENGTH_LONG).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["fullname"] = name.toString()
                params["username"] = username.toString()
                params["password"] = password.toString()
                return params
            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
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