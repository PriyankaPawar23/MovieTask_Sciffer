package com.example.sciffertask.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_list")
data class MovieList (

    @SerializedName("Title") val title : String,
    @SerializedName("Year") val year : Int,
    @SerializedName("Summary") val summary : String,
    @SerializedName("Short Summary") val shortSummary : String,
    @SerializedName("Genres") val genres : String,
    @PrimaryKey
    @SerializedName("IMDBID") val iMDBID : String,
    @SerializedName("Runtime") val runtime : Int,
    //@SerializedName("YouTube Trailer") val youTubeTrailer : String?,
    @SerializedName("Rating") val rating : Double,
    @SerializedName("Movie Poster") val moviePoster : String,
    @SerializedName("Director") val director : String,
    @SerializedName("Writers") val writers : String,
    @SerializedName("Cast") val cast : String

)