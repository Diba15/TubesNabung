package com.d3if2089.contohpt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.d3if2089.contohpt2.databinding.ActivityDetailWishlistBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

        setData()

        binding.addButton.setOnClickListener {
            val nominal = binding.nominalEditText.text.toString()
            if (TextUtils.isEmpty(nominal)) {
                Toast.makeText(this, "Nominal tidak boleh kosong.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_wishlist, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.hapusWishlist) {
            hapusWishlist()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hapusWishlist() {
        MaterialAlertDialogBuilder(this)
            .setMessage("Hapus Wishlist?")
            .setPositiveButton("Hapus") { _, _ ->
                Toast.makeText(
                    this, "Wishlist di hapus", Toast.LENGTH_LONG
                ).show()
            }
            .setNegativeButton("Batal") { dialog, _ ->
                dialog.cancel()
            }.show()
    }

    private fun setData() {
        //Get data intent
        val nama = intent.getStringExtra("nama")
        val goal = intent.getIntExtra("goal", 0)
        val terkumpul = intent.getIntExtra("terkumpul", 0)
        val jumlahHari = intent.getIntExtra("jumlahHari", 0)
        val imageId = intent.getIntExtra("imageId", 0)

        val formatter = DecimalFormat("#,###")

        binding.titleText.text = nama
        var formatAngka = formatter.format(goal)
        binding.detailGoalValue.text = "Rp. $formatAngka"
        formatAngka = formatter.format(terkumpul)
        binding.detailTerkumpulValue.text = "Rp. $formatAngka"
        binding.detailJumlahHari.text = jumlahHari.toString()
        binding.detailImage.setImageResource(imageId)

        if (goal == terkumpul) {
            binding.nominalEditText.isEnabled = false
            binding.addButton.isEnabled = false
        }
    }
}