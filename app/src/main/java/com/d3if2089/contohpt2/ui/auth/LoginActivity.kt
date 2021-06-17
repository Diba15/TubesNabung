package com.d3if2089.contohpt2.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.d3if2089.contohpt2.Config
import com.d3if2089.contohpt2.MainActivity
import com.d3if2089.contohpt2.databinding.ActivityLoginBinding
import com.d3if2089.contohpt2.ui.WelcomeActivity
import org.json.JSONException
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent()

        binding.btnLogin.setOnClickListener {

        }
    }

    private fun loginSystem() {
        val url = Config.login
        val username = binding.usernameEditText.text?.trim()
        val password = binding.passwordEditText.text?.trim()

//        val stringRequest = object : StringRequest(Method.POST, url,
//            { response ->
//                if (response.contains("Success")) {
//                    Toast.makeText(this, "Login Berhasil", Toast.LENGTH_LONG).show()
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivityForResult(intent)
//                } else {
//                    Toast.makeText(this, "username atau password salah!", Toast.LENGTH_LONG).show()
//                }
//            }, {
//                Toast.makeText(this,"Server Unreachable", Toast.LENGTH_LONG).show()
//            }) {
//            @Throws(AuthFailureError::class)
//            override fun getParams(): Map<String, String> {
//                val params = HashMap<String, String>()
//                params["username"] = username as String
//                params["password"] = password as String
//                return params
//            }
//        }
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