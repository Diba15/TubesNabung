package com.d3if2089.contohpt2.network

import com.d3if2089.contohpt2.data.login.ResponseLogin
import com.d3if2089.contohpt2.data.statistik.ResponseInsertStatistik
import com.d3if2089.contohpt2.data.statistik.ResponseListStatistik
import com.d3if2089.contohpt2.data.wishlist.ResponseWishlist
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiClient {
    @FormUrlEncoded
    @POST("login_210616122019.php")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<ResponseLogin>

    @POST("listWishlist.php")
    fun showWishlist(
        @Field("idUser") idUser: Int
    ): Call<ResponseWishlist>

    @FormUrlEncoded
    @POST("listStatistik.php")
    fun showStatistik(
        @Field("idUser") idUser: Int
    ): Call<ResponseListStatistik>

    @FormUrlEncoded
    @POST("insertStatistik.php")
    fun insertStatistik(
        @Field("idUser") idUser: Int,
        @Field("category") category: String,
        @Field("value") value: Float,
        @Field("detail") detail: String
    ): Call<ResponseInsertStatistik>
}