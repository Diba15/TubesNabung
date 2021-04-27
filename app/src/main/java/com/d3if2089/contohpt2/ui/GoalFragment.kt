package com.d3if2089.contohpt2.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.d3if2089.contohpt2.GoalAdapter
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.data.Goal
import com.d3if2089.contohpt2.databinding.FragmentGoalBinding
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
    private var list = listOf(
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
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGoalBinding.inflate(layoutInflater, container, false)
        with(binding.goalRecycleView) {
            adapter = GoalAdapter(getData())
            setHasFixedSize(true)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getData(): List<Goal> {
        return list
    }

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
        MaterialAlertDialogBuilder(requireContext())
            .setMessage("Are you want to clear goal?")
            .setPositiveButton("Clear") { _, _ ->
                getData().drop(1)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .show()
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