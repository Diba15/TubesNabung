package com.d3if2089.contohpt2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.d3if2089.contohpt2.databinding.ActivityMainBinding
import com.d3if2089.contohpt2.ui.profile.ProfileFragment
import com.d3if2089.contohpt2.ui.statistic.StatisticFragment
import com.d3if2089.contohpt2.ui.wishlist.WishlistFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val wishlistFragment = WishlistFragment()
    private val statisticFragment = StatisticFragment()
    private val profileFragment = ProfileFragment()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Membuat agar bisa menggunakan custom appbar
        setSupportActionBar(binding.layoutToolbar)

        //mengatur halaman awal fragment
        currentPage(profileFragment)
        //Membuat agar navigasi berfungsi
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.wishlist -> {
                    binding.titleText.text = getString(R.string.wishlist)
                    val argumentWishlist = Bundle()
                    with(argumentWishlist) {
                        putInt("id_user",intent.getIntExtra("id",0))
                        putFloat("tabungan", intent.getFloatExtra("tabungan",0f))
                    }
                    wishlistFragment.arguments = argumentWishlist
                    currentPage(wishlistFragment)
                }
                R.id.profile -> {
                    binding.titleText.text = "Profile"
                    val argumentProfile = Bundle()
                    with(argumentProfile) {
                        putString("name", intent.getStringExtra("name"))
                        putString("username", intent.getStringExtra("username"))
                        putFloat("tabungan", intent.getFloatExtra("tabungan",0f))
                    }
                    profileFragment.arguments = argumentProfile
                    currentPage(profileFragment)
                }
                R.id.statistik -> {
                    binding.titleText.text = getString(R.string.statistic)
                    val argumentStatistik = Bundle()
                    with(argumentStatistik) {
                        putInt("id_user",intent.getIntExtra("id",0))
                        putFloat("tabungan", intent.getFloatExtra("tabungan",0f))
                    }
                    statisticFragment.arguments = argumentStatistik
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