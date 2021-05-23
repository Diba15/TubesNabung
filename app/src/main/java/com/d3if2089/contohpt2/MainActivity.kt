package com.d3if2089.contohpt2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.d3if2089.contohpt2.databinding.ActivityMainBinding
import com.d3if2089.contohpt2.ui.goal.GoalFragment
import com.d3if2089.contohpt2.ui.profile.ProfileFragment
import com.d3if2089.contohpt2.ui.statistic.StatisticFragment
import com.d3if2089.contohpt2.ui.wishlist.WishlistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val wishlistFragment = WishlistFragment()
    private val statisticFragment = StatisticFragment()
    private val goalFragment = GoalFragment()
    private val profileFragment = ProfileFragment()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Membuat agar bisa menggunakan custom appbar
        setSupportActionBar(binding.layoutToolbar)

        //Membuat agar bisa menggunakan custom appbar
        setSupportActionBar(binding.layoutToolbar)
        //mengatur halaman awal fragment
        currentPage(WishlistFragment())
        //Membuat agar navigasi berfungsi
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
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
    }

    private fun currentPage(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.frame_layout, fragment)
        commit()
    }
}