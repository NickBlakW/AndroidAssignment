package com.example.androidassignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetroClient(param : String?) {
    private val url = "https://api.themoviedb.org/3/movie/"

    fun getRetroClient() : Api {
        return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
    }
}