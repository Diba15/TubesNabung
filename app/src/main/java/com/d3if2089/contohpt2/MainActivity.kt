package com.d3if2089.contohpt2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.d3if2089.contohpt2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Membuat agar bisa menggunakan custom appbar
        setSupportActionBar(binding.layoutToolbar)

        //Set Nav
        navController = findNavController(R.id.nav_host_fragment)
        val navView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.wishlistFragment,
                R.id.goalFragment,
                R.id.statisticFragment,
                R.id.profileFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)
    }
}