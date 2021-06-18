package com.d3if2089.contohpt2.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.d3if2089.contohpt2.MainActivity
import com.d3if2089.contohpt2.data.login.ResponseLogin
import com.d3if2089.contohpt2.databinding.ActivityLoginBinding
import com.d3if2089.contohpt2.network.RetrofitClient
import com.d3if2089.contohpt2.ui.WelcomeActivity
import retrofit2.Call
import retrofit2.Callback

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var username: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent()

        binding.btnLogin.setOnClickListener {
            username = binding.usernameEditText.text?.trim().toString()
            password = binding.passwordEditText.text?.trim().toString()

            if (username == "") {
                binding.registerTl.error = "Username tidak boleh kosong!"
            } else if (password == "") {
                binding.passRegisTl.error = "Password tidak boleh kosong!"
            } else {
                getData()
            }

        }
    }

    private fun getData() {

        val api = RetrofitClient().getInstance()
        with(api) {
            login(username, password).enqueue(object : Callback<ResponseLogin> {
                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: retrofit2.Response<ResponseLogin>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()?.response == true) {
                            Toast.makeText(this@LoginActivity,"Login Success",Toast.LENGTH_LONG).show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            binding.progressBarLogin.visibility = View.VISIBLE
                            binding.waitLogin.visibility = View.VISIBLE
                            val bundle = Bundle()
                            with(bundle) {
                                putInt("id", response.body()!!.logmo.id_user)
                                putString("name", response.body()!!.logmo.name)
                                putString("username", response.body()!!.logmo.username)
                                putFloat("tabungan",response.body()!!.logmo.tabungan)
                            }
                            intent.putExtras(bundle)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity,"Gagal",Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    t.message?.let { Log.e("ErrorRetro", it) }
                }

            })
        }
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