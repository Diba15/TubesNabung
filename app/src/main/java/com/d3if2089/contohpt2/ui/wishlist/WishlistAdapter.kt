package com.d3if2089.contohpt2.ui.wishlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d3if2089.contohpt2.data.WishList
import com.d3if2089.contohpt2.databinding.ItemWishlistBinding
import java.text.DecimalFormat

class WishlistAdapter(private val data: List<WishList>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemWishlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishList: WishList) = with(binding) {
            textNamaBarang.text = wishList.nama
            val formatter = DecimalFormat("#,###")
            var formatAngka = formatter.format(wishList.goal)
            valueGoalWishlist.text = "Rp. $formatAngka"
            angkaHari.text = wishList.jumlahHari.toString()
            formatAngka = formatter.format(wishList.terkumpul)
            valueKumpulWishlist.text = "Rp. $formatAngka"
            binding.progressBarGoal.max = wishList.goal
            val currentProgress = wishList.terkumpul
            binding.progressBarGoal.progress = currentProgress
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
    }


}