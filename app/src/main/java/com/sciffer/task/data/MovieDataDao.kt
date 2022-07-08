package com.sciffer.task.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sciffertask.model.MovieList

@Dao
interface MovieDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(movieList: List<MovieList>)

    @Query("Select * FROM movie_list")
    suspend fun getMovieList() : List<MovieList>
}