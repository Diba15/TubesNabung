package com.d3if2089.contohpt2.ui.wishlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.d3if2089.contohpt2.DetailWishlist
import com.d3if2089.contohpt2.data.WishList
import com.d3if2089.contohpt2.databinding.ItemWishlistBinding
import java.text.DecimalFormat

class WishlistAdapter(private val data: List<WishList>,
    var handler: (Int, WishList) -> Unit) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(val binding: ItemWishlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishList: WishList) = with(binding) {
            textNamaBarang.text = wishList.nama
            val formatter = DecimalFormat("#,###")
            var formatAngka = formatter.format(wishList.goal)
            valueGoalWishlist.text = "Rp. $formatAngka"
            angkaHari.text = wishList.jumlahHari.toString()
            binding.progressBarGoal.max = wishList.goal
            val currentProgress = wishList.terkumpul
            binding.progressBarGoal.progress = currentProgress
            Glide.with(this.root)
                .load(wishList.imageResId)
                .into(wishlistImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWishlistBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        val item = data[position]
        with(holder) {
            bind(item)
            binding.root.setOnClickListener { handler(position, item) }
        }
    }

}