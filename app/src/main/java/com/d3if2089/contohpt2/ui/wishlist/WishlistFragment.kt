package com.d3if2089.contohpt2.ui.wishlist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.d3if2089.contohpt2.MainActivity
import com.d3if2089.contohpt2.R
import com.d3if2089.contohpt2.data.WishList
import com.d3if2089.contohpt2.data.login.ResponseLogin
import com.d3if2089.contohpt2.data.wishlist.ResponseWishlist
import com.d3if2089.contohpt2.databinding.FragmentWishlistBinding
import com.d3if2089.contohpt2.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WishlistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WishlistFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentWishlistBinding
    private lateinit var wishlistAdapter: WishlistAdapter

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
        binding = FragmentWishlistBinding.inflate(layoutInflater, container, false)
        binding.floatingAddButton.setOnClickListener {
            startActivity(Intent(context, AddWishlist::class.java))
        }
        getData()
        return binding.root
    }

    private fun getData() {
        val list: MutableList<WishList> = listOf(
            WishList("Meja Belajar", 20000, R.drawable.meja_belajar, 20000, 20),
            WishList("Laptop", 10000000, R.drawable.laptop, 5000000, 60)
        ).toMutableList()

        wishlistAdapter = WishlistAdapter(list) { _, item ->

            val bundleStatus = Bundle()
            with(bundleStatus) {
                putString("nama", item.nama)
                putInt("goal", item.goal)
                putInt("terkumpul", item.terkumpul)
                putInt("jumlahHari", item.jumlahHari)
                putInt("imageId", item.imageResId)
            }

            val intent = Intent(context, DetailWishlist::class.java)
            intent.putExtras(bundleStatus)
            startActivity(intent)
        }

        with(binding.wishlistRecycleView) {
            adapter = wishlistAdapter
            setHasFixedSize(true)
        }
    }

    private fun getWishlist() {
        val bundle = this.arguments
        var idUser = 0
        if (bundle != null) {
            idUser = bundle.getInt("id_user")
        }
        val api = RetrofitClient().getInstance()
        with(api) {
            showWishlist(idUser).enqueue(object : Callback<ResponseWishlist> {
                override fun onResponse(
                    call: Call<ResponseWishlist>,
                    response: Response<ResponseWishlist>
                ) {
                    if (response.isSuccessful) {

                    }
                }

                override fun onFailure(call: Call<ResponseWishlist>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WishlistFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WishlistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}