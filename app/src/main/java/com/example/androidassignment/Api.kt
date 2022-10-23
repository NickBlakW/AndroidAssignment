package com.example.androidassignment

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface Api {
    @GET("popular?api_key=a889f0273ab1c2b2dec28a2f14a81643&language=en-US&page=1")
    fun fetchData() : Call<JResponse>
}