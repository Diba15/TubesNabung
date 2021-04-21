package com.d3if2089.contohpt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.d3if2089.contohpt2.databinding.ActivityMainBinding
import com.d3if2089.contohpt2.ui.GoalFragment
import com.d3if2089.contohpt2.ui.ProfileFragment
import com.d3if2089.contohpt2.ui.StatisticFragment
import com.d3if2089.contohpt2.ui.WishlistFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(myToolbar)

        currentPage(WishlistFragment())
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.wishlist -> currentPage(WishlistFragment())
                R.id.profile -> currentPage(ProfileFragment())
                R.id.goal -> currentPage(GoalFragment())
                R.id.statistik -> currentPage(StatisticFragment())
            }
            true
        }
    }

    private fun currentPage(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.frame_layout, fragment)
        commit()
    }
}