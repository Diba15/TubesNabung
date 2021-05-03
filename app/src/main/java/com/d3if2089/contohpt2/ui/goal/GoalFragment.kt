package com.d3if2089.contohpt2.ui.goal

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.data.Goal
import com.d3if2089.contohpt2.databinding.FragmentGoalBinding
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.dialog.MaterialAlertDialogBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GoalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GoalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentGoalBinding
    private var list: MutableList<Goal> = mutableListOf(
        Goal("OKT", 30000, 30000),
        Goal("NOV", 30000, 20000),
        Goal("DES", 30000, 15000),
        Goal("JAN", 60000, 23000),
        Goal("FEB", 100000, 50000),
        Goal("MAR", 90000, 80000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGoalBinding.inflate(layoutInflater, container, false)
        //Membuat Recycler View memiliki data
        with(binding.goalRecycleView) {
            adapter = GoalAdapter(getData())
            setHasFixedSize(true)
        }
        //Membuat agar menu appbar muncul
        setHasOptionsMenu(true)
        setBarChart()
        return binding.root
    }

    private fun getData(): MutableList<Goal> {
        return list
    }

    //Inisiasi Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.clearAll) {
            clearData()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun clearData() {
        //Membuat pop up dialog
        MaterialAlertDialogBuilder(requireContext())
            .setMessage("Are you want to clear goal?")
            .setPositiveButton("Clear") { _, _ ->
                list.clear()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    private fun setBarChart() {
        val barChart = binding.barChart
        val yAxis = barChart.axisRight
        val xAxis = barChart.xAxis

        val xValues = ArrayList<String>()
        xValues.add("OKT")
        xValues.add("NOV")
        xValues.add("DES")
        xValues.add("JAN")
        xValues.add("FEB")
        xValues.add("MAR")

        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(30000f, 0))
        barEntries.add(BarEntry(20000f, 1))
        barEntries.add(BarEntry(15000f, 2))
        barEntries.add(BarEntry(23000f, 3))
        barEntries.add(BarEntry(50000f, 4))
        barEntries.add(BarEntry(80000f, 5))


        val barDataSet = BarDataSet(barEntries,"Terkumpul")
        barDataSet.color= resources.getColor(R.color.royal_blue)

        val finalDataSet = ArrayList<BarDataSet>()
        finalDataSet.add(barDataSet)

        val data = BarData(xValues,finalDataSet as List<BarDataSet>?)
        yAxis.setLabelCount(0, true)
        xAxis.setLabelsToSkip(4)
        barChart.setDescription(null)

        barChart.data = data
        barChart.setBackgroundColor(resources.getColor(R.color.white))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GoalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GoalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}