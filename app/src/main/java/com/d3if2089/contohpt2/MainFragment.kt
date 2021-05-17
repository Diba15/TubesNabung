package com.d3if2089.contohpt2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.d3if2089.contohpt2.databinding.FragmentMainBinding
import com.d3if2089.contohpt2.ui.goal.GoalFragment
import com.d3if2089.contohpt2.ui.profile.ProfileFragment
import com.d3if2089.contohpt2.ui.statistic.StatisticFragment
import com.d3if2089.contohpt2.ui.wishlist.WishlistFragment
import kotlinx.android.synthetic.main.activity_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentMainBinding
    private val wishlistFragment = WishlistFragment()
    private val statisticFragment = StatisticFragment()
    private val goalFragment = GoalFragment()
    private val profileFragment = ProfileFragment()

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
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        //Membuat agar bisa menggunakan custom appbar
        (activity as AppCompatActivity).setSupportActionBar(binding.layoutToolbar)
        //mengatur halaman awal fragment
        currentPage(WishlistFragment())
        //Membuat agar navigasi berfungsi
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.wishlist -> {
                    binding.titleText.text = getString(R.string.wishlist)
                    currentPage(wishlistFragment)
                }
                R.id.profile -> {
                    binding.titleText.text = "Profile"
                    currentPage(profileFragment)
                }
                R.id.goal -> {
                    binding.titleText.text = getString(R.string.goal_title)
                    currentPage(goalFragment)
                }
                R.id.statistik -> {
                    binding.titleText.text = getString(R.string.statistic)
                    currentPage(statisticFragment)
                }
            }
            true
        }
        return binding.root
    }

    private fun currentPage(fragment: Fragment) =
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}