package com.d3if2089.contohpt2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d3if2089.contohpt2.data.Kategori
import com.d3if2089.contohpt2.databinding.ItemStatisticBinding
import java.text.DecimalFormat

class StatisticAdapter(private val data: List<Kategori>) :
    RecyclerView.Adapter<StatisticAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemStatisticBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(kategori: Kategori) = with(binding) {
            if (kategori.kategori == "Pemasukan") {
                iconPemasukan.setImageResource(R.drawable.icon_pemasukan)
            } else {
                iconPemasukan.setImageResource(R.drawable.icon_pengeluaran)
            }
            val formatter = DecimalFormat("#,###")
            val formatAngka = formatter.format(kategori.value)
            namaKegiatan.text = kategori.name
            valueHistory.text = "Rp. $formatAngka"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStatisticBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


}