package com.d3if2089.contohpt2.ui.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.d3if2089.contohpt2.data.Kategori
import com.d3if2089.contohpt2.databinding.FragmentStatisticBinding

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
    var months: Array<String> = arrayOf("Jan","Feb","Mar")
    var values: Array<Int> = arrayOf(3000,2000,3000)

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
        binding = FragmentStatisticBinding.inflate(layoutInflater,container,false)
        with(binding.recyclerStatis) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = StatisticAdapter(getData())
            setHasFixedSize(true)
        }
        return binding.root
    }

    private fun getData(): List<Kategori> {
        return listOf(
            Kategori("Pemasukan","Gajian",3000000),
            Kategori("Pengeluaran","Beli PS5",8000000),
            Kategori("Pemasukan","Bonus",2000000),
            Kategori("Pengeluaran","Makan",1000000)
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
}