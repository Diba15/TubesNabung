package com.d3if2089.contohpt2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d3if2089.contohpt2.data.History
import com.d3if2089.contohpt2.databinding.ListHistoryBinding

class MainAdapter(private val data: List<History>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListHistoryBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) = with(binding) {
            monthHistory.text =history.month
            valuePemasukan.text = "+ Rp. " + history.pemasukan.toString()
            valuePengeluaran.text = "- Rp. " + history.pengeluaran.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val binding =ListHistoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }


}