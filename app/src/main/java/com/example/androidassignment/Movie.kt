package com.example.androidassignment

import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("title") var title: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("poster_path") var poster_path: String,
)
{}