package com.example.sciffertask.model

import com.google.gson.annotations.SerializedName

data class MovieBase (

    @SerializedName("Movie List") val movie_List : List<MovieList>
)