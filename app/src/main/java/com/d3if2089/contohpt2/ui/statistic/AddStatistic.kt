package com.d3if2089.contohpt2.ui.statistic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.data.statistik.ResponseInsertStatistik
import com.d3if2089.contohpt2.data.wishlist.ResponseWishlist
import com.d3if2089.contohpt2.databinding.ActivityAddStatisticBinding
import com.d3if2089.contohpt2.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddStatistic : AppCompatActivity() {
    private lateinit var binding: ActivityAddStatisticBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.layoutToolbar)
        binding.submitBtn.setOnClickListener {
            addStatistik()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.titleText.text = "Add Statistic"
    }

    private fun addStatistik() {
        val idUser = intent.getIntExtra("id_user", 0)
        val nominal = binding.nominalEditText.text.toString().toFloat()
        val radioGroupCate = binding.jenismasukan.checkedRadioButtonId
        val radioButtonCate = findViewById<RadioButton>(radioGroupCate)
        val cateString = radioButtonCate.text.toString()
        val detail = binding.keteranganEditText.text.toString()
        val api = RetrofitClient().getInstance()
        with(api) {
            insertStatistik(idUser, cateString, nominal, detail).enqueue(object :
                Callback<ResponseInsertStatistik> {
                override fun onResponse(
                    call: Call<ResponseInsertStatistik>,
                    response: Response<ResponseInsertStatistik>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()?.response == true) {
                            Toast.makeText(
                                this@AddStatistic,
                                "Statistik Berhasil ditambahkan $idUser",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                this@AddStatistic,
                                "False CUk",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        Toast.makeText(this@AddStatistic,"Gagal",Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ResponseInsertStatistik>, t: Throwable) {
                    t.message?.let { Log.e("ErrorRetro", it) }
                }

            })
        }
    }
}