package com.d3if2089.contohpt2.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.d3if2089.contohpt2.Config
import com.d3if2089.contohpt2.MainActivity
import com.d3if2089.contohpt2.data.ResponseLogin
import com.d3if2089.contohpt2.databinding.ActivityLoginBinding
import com.d3if2089.contohpt2.network.RetrofitClient
import com.d3if2089.contohpt2.ui.WelcomeActivity
import org.json.JSONException
import org.json.JSONObject
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

            getData()
        }
    }

//    private fun loginSystem(username: String, password: String) {
//        val url = Config.login
//        val stringRequest = object : StringRequest(Method.POST, url,
//            { response ->
//                try {
//                    val jsonObject = JSONObject(response)
//                    Log.d("JSONR", jsonObject.toString())
//                    val success = jsonObject.getString("success")
//                    val jsonArray = jsonObject.getJSONArray("login")
//
//                    if (success.equals("1")) {
//                        for (i in 0 until jsonArray.length()) {
//                            val user = jsonArray.getJSONObject(i)
//                            val name = user.getString("name").trim()
//                            val getUsername = user.getString("username").trim()
//
//                            Toast.makeText(this, "Success $name, $getUsername", Toast.LENGTH_LONG)
//                                .show()
//                        }
//                    }
//                } catch (e: JSONException) {
//                    Toast.makeText(this, "Failure $e", Toast.LENGTH_LONG).show()
//                    Log.d("Error", e.toString());
//                }
//            }, {
//                Toast.makeText(this, "Server Unreachable", Toast.LENGTH_LONG).show()
//            }) {
//            @Throws(AuthFailureError::class)
//            override fun getParams(): Map<String, String> {
//                val params = HashMap<String, String>()
//                params["username"] = username
//                params["password"] = password
//                return params
//            }
//        }
//        val requestQueue = Volley.newRequestQueue(this)
//        requestQueue.add(stringRequest)
//    }

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
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
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