package com.d3if2089.contohpt2.network

import com.d3if2089.contohpt2.data.ResponseLogin
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
}