package com.sciffer.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.sciffer.task.adpater.MovieAdapter
import com.sciffer.task.viewmodel.MovieViewModel
import com.sciffer.task.viewmodel.MovieViewModelFactory

import com.sciffer.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var movieViewModel: MovieViewModel

    private val adapter = MovieAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val repository = (application as MyApplication).movieRepository

        movieViewModel = ViewModelProvider(this,MovieViewModelFactory(repository)).get(MovieViewModel::class.java)

        binding.recyclerView.adapter = adapter


        //new data fetch from another api
        binding.refresh.setOnClickListener(View.OnClickListener {
            movieViewModel.getNewMovies()
            movieViewModel.movies.observe(this, { adapter.setMovies(this,it.movie_List) })
        }
        )


        //default data
        movieViewModel.movies.observe(this, { adapter.setMovies(this,it.movie_List) })

        movieViewModel.getAllMovies()
    }
}