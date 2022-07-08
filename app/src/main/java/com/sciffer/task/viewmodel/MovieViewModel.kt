package com.sciffer.task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sciffertask.model.MovieBase
import com.sciffer.task.repository.MovieRepository
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import retrofit2.Callback

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    var job: Job? = null


    //get default data
    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO).launch {
            movieRepository.getMoviesList()
        }
    }

    //get new data
    fun getNewMovies() {
        job = CoroutineScope(Dispatchers.IO).launch {
            movieRepository.getNewMoviesList()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }


    val movies : LiveData<MovieBase>
    get() = movieRepository.movies


}