package com.d3if2089.contohpt2.ui.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d3if2089.contohpt2.databinding.ActivityAddWishlistBinding

class AddWishlist : AppCompatActivity() {

    private lateinit var binding: ActivityAddWishlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddWishlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.layoutToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.titleText.text = "Add Wishlist"
    }
}