package com.d3if2089.contohpt2.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.data.Kategori
import com.d3if2089.contohpt2.databinding.FragmentStatisticBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StatisticFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatisticFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentStatisticBinding
    var months: Array<String> = arrayOf("Jan", "Feb", "Mar")
    var values: Array<Int> = arrayOf(3000, 2000, 3000)

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
        binding = FragmentStatisticBinding.inflate(layoutInflater, container, false)
        with(binding.recyclerStatis) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = StatisticAdapter(getData())
            setHasFixedSize(true)
        }
        setLineChartData()
        return binding.root
    }

    private fun getData(): List<Kategori> {
        return listOf(
            Kategori("Pemasukan", "Gajian", 3000000),
            Kategori("Pengeluaran", "Beli PS5", 8000000),
            Kategori("Pemasukan", "Bonus", 2000000),
            Kategori("Pengeluaran", "Makan", 1000000)
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StatisticFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatisticFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setLineChartData() {
        val lineChart = binding.pieChart
        val yRight = lineChart.axisRight
        val yLeft = lineChart.axisLeft

        val xvalue = ArrayList<String>()
        xvalue.add("")
        xvalue.add("")


        val lineentry = ArrayList<Entry>()
        lineentry.add(Entry(3000000f, 0))
        lineentry.add(Entry(2000000f, 1))

        val lineentry1 = ArrayList<Entry>()
        lineentry1.add(Entry(8000000f, 0))
        lineentry1.add(Entry(1000000f, 1))

        val linedataset = LineDataSet(lineentry, "Pemasukan")
        linedataset.setDrawCircles(false)
        linedataset.color = resources.getColor(R.color.green)

        val linedataset1 = LineDataSet(lineentry1, "Pengeluaran")
        linedataset1.setDrawCircles(false)
        linedataset1.color = resources.getColor(R.color.red)

        val finaldataset = ArrayList<LineDataSet>()
        finaldataset.add(linedataset)
        finaldataset.add(linedataset1)

        yRight.setLabelCount(0, true)
        yLeft.setLabelCount(5, true)
        yLeft.setStartAtZero(true)
        yRight.setStartAtZero(true)
        lineChart.setDescription("MEI")
        lineChart.setDescriptionColor(R.color.black)
        lineChart.setDescriptionTextSize(10f)


        val data = LineData(xvalue, finaldataset as List<ILineDataSet>?)
        lineChart.data = data
        lineChart.invalidate()
        lineChart.setBackgroundColor(resources.getColor(R.color.white))
    }
}