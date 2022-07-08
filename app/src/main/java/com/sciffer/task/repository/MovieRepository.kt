package com.sciffer.task.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sciffertask.model.MovieBase
import com.example.sciffertask.model.MovieList
import com.sciffer.task.api.ApiInterface
import com.sciffer.task.database.MovieDatabase
import com.sciffer.task.util.MyUtil

class MovieRepository(
     private val apiInterface: ApiInterface,
     private val movieDatabase: MovieDatabase,
     private val applicationContext: Context
 ) {
    private val movieLiveData = MutableLiveData<MovieBase>()

    val movies : LiveData<MovieBase>
    get() = movieLiveData


    //fetch default data from api
    suspend fun getMoviesList()
    {
        //if internet is available fetch data from api
        if(MyUtil.isInternetAvailable(applicationContext))
        {
            val result = apiInterface.getMovie("/1.json")
            if(result.body()!=null)
            {
                movieDatabase.movieDao().insertMovieList(result.body()!!.movie_List)

                movieLiveData.postValue(result.body())
                Log.e("Live Database","Live")
            }
        }

        //if internet is not available fetch data from room database
        else
        {
            val movie = movieDatabase.movieDao().getMovieList()

            val movieList=MovieBase(movie)

            movieLiveData.postValue(movieList)

            Log.e("Room Database","Room")
        }
    }


    //fetch new data from api
    suspend fun getNewMoviesList()
    {
        val result = apiInterface.getMovie("/2.json")
            if(result.body()!=null)
            {
                movieDatabase.movieDao().insertMovieList(result.body()!!.movie_List)

                movieLiveData.postValue(result.body())
                Log.e("Live Database","Live")
            }
    }
}