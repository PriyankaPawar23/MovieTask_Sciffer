package com.sciffer.task.api

import com.example.sciffertask.model.MovieBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {

    @GET
    suspend fun getMovie(@Url url:String) : Response<MovieBase>

}