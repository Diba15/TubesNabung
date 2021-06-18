package com.d3if2089.contohpt2.data.wishlist

data class ListWishlist(
    val id: Int,
    val id_user: Int,
    val name: String,
    val harga: Float,
    val terkumpul: Float,
    val deadline: Int,
    val image: String
)
