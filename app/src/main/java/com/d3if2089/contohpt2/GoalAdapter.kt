package com.d3if2089.contohpt2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d3if2089.contohpt2.data.Goal
import com.d3if2089.contohpt2.databinding.ListGoalBinding

class GoalAdapter(private val data: List<Goal>):
RecyclerView.Adapter<GoalAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListGoalBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(goal: Goal) = with(binding) {
            monthHistory.text =goal.month
            valuePemasukan.text = "Rp. " + goal.terkumpul.toString()
            valuePengeluaran.text = "Rp. " + goal.goal.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListGoalBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GoalAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }


}