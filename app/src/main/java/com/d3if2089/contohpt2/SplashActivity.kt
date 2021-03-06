package com.d3if2089.contohpt2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.d3if2089.contohpt2.ui.WelcomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Menggunakan handler agar bepindah halaman sedikit lebih lama
        Handler().postDelayed({
            kotlin.run {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        },2500)

    }
}