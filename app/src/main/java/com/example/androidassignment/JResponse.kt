package com.example.androidassignment

import com.google.gson.annotations.SerializedName

class JResponse (
    @SerializedName("results")
    var results: ArrayList<Movie>)