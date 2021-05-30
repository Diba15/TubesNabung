package com.d3if2089.contohpt2.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WishList(
    val nama: String,
    val goal: Int,
    val imageResId: Int,
    val terkumpul: Int,
    val jumlahHari: Int
): Parcelable
