package com.d3if2089.contohpt2.ui.goal

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d3if2089.contohpt2.data.Goal
import com.d3if2089.contohpt2.databinding.ItemGoalBinding
import java.text.DecimalFormat

class GoalAdapter(private val data: List<Goal>) :
    RecyclerView.Adapter<GoalAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemGoalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(goal: Goal) = with(binding) {
            monthHistory.text = goal.month
            val formatter = DecimalFormat("#,###")
            var formatAngka = formatter.format(goal.terkumpul)
            valuePemasukan.text = "Rp. $formatAngka"
            formatAngka = formatter.format(goal.goal)
            valuePengeluaran.text = "Rp. $formatAngka"
            binding.progressBarGoal.max = goal.goal
            val currentProgress = goal.terkumpul
            binding.progressBarGoal.progress = currentProgress

            val percentage = ((currentProgress.toDouble() /
                    binding.progressBarGoal.max) * 100).toInt()

            goalPercentage.text = "$percentage%"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoalBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}