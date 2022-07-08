package com.sciffer.task.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sciffertask.model.MovieList
import com.sciffer.task.data.MovieDataDao

@Database(entities =[MovieList::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDataDao

    companion object
    {
        private var INSTANCE : MovieDatabase?= null

        fun getDatabase(context: Context):MovieDatabase
        {
            if (INSTANCE == null)
            {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MovieDatabase::class.java,
                    "movieDB"
                ).build()
            }
            return INSTANCE!!
        }
    }
}