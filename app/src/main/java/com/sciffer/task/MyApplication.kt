package com.sciffer.task

import android.app.Application
import com.sciffer.task.api.ApiInterface
import com.sciffer.task.api.ApiUtilities
import com.sciffer.task.database.MovieDatabase
import com.sciffer.task.repository.MovieRepository

class MyApplication : Application() {

    lateinit var movieRepository: MovieRepository

    override fun onCreate() {
        super.onCreate()

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)

        val database = MovieDatabase.getDatabase(applicationContext)

        movieRepository = MovieRepository(apiInterface,database,applicationContext)
    }
}