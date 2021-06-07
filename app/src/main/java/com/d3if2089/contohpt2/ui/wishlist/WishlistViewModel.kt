package com.d3if2089.contohpt2.ui.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.data.WishList

class WishlistViewModel: ViewModel() {
    private val data = MutableLiveData<List<WishList>>()

    init {
        data.value = initData()
    }

    private fun initData(): List<WishList> {
        return listOf(
            WishList("Meja Belajar", 20000, R.drawable.meja_belajar, 20000, 20),
            WishList("Laptop", 10000000, R.drawable.laptop, 5000000, 60)
        )
    }

    fun getData(): LiveData<List<WishList>> = data
}