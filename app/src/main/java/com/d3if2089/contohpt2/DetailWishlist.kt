package com.d3if2089.contohpt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.d3if2089.contohpt2.databinding.ActivityDetailWishlistBinding
import java.text.DecimalFormat

class DetailWishlist : AppCompatActivity() {
    private lateinit var binding: ActivityDetailWishlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Membuat agar bisa menggunakan custom appbar
        setSupportActionBar(binding.layoutToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nama = intent.getStringExtra("nama")
        val goal = intent.getIntExtra("goal", 0)
        val terkumpul = intent.getIntExtra("terkumpul",0)
        val jumlahHari = intent.getIntExtra("jumlahHari",0)
        val imageId = intent.getIntExtra("imageId",0)

        val formatter = DecimalFormat("#,###")

        binding.titleText.text = nama
        var formatAngka = formatter.format(goal)
        binding.detailGoalValue.text = "Rp. $formatAngka"
        formatAngka = formatter.format(terkumpul)
        binding.detailTerkumpulValue.text = "Rp. $formatAngka"
        binding.detailJumlahHari.text = jumlahHari.toString()
        binding.detailImage.setImageResource(imageId)
    }
}