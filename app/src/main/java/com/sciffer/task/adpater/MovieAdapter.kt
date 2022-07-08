package com.sciffer.task.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sciffertask.model.MovieList
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sciffer.task.MainActivity
import com.sciffer.task.R
import com.sciffer.task.databinding.MovieListItemBinding
import com.squareup.picasso.Picasso
import org.w3c.dom.Text


class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var movieList = mutableListOf<MovieList>()
    lateinit var context:Context

    private val picasso= Picasso.get()

    fun setMovies(context: Context,movies: List<MovieList>) {
        this.movieList = movies.toMutableList()
        this.context=context
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieListItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = movieList[position]
        holder.binding.title.text=movie.title
        picasso.load(movie.moviePoster).into(holder.binding.imageview)
        holder.binding.year.text= movie.year.toString()
        holder.binding.dot.text="."
        holder.binding.dot1.text="."
        holder.binding.runtime.text=movie.runtime.toString() +" min"
        holder.binding.rating.text=movie.rating.toString()



        //botton sheet dialog to show movie details
        holder.binding.cardView.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(context)
            val view: View = LayoutInflater.from(context).inflate(
                R.layout.movie_details,null
            )
            val btitle: TextView
            val bimg: ImageView
            val byear: TextView
            val bdot:TextView
            val bdot1:TextView
            val bruntime: TextView
            val brating:TextView
            val bgeners:TextView
            val bsummary:TextView
            val bdirector:TextView
            val bwriter:TextView
            val bcast:TextView
            btitle = view.findViewById(R.id.title)
            byear = view.findViewById(R.id.year)
            bimg = view.findViewById(R.id.imageview)
            bruntime = view.findViewById(R.id.runtime)
            bdot = view.findViewById(R.id.dot)
            bdot1 = view.findViewById(R.id.dot1)
            brating = view.findViewById(R.id.rating)
            bsummary = view.findViewById(R.id.summary)
            bdirector = view.findViewById(R.id.director)
            bcast = view.findViewById(R.id.cast)
            bwriter = view.findViewById(R.id.writer)
            bgeners=view.findViewById(R.id.genres)


            btitle.text=movie.title
            byear.text= movie.year.toString()
            bruntime.text=movie.runtime.toString()+" min"
            brating.text=movie.rating.toString()
            bdot.text="."
            bdot1.text="."
            bgeners.text=movie.genres
            bsummary.text=movie.summary
            bdirector.text=movie.director
            bcast.text=movie.cast
            bwriter.text=movie.writers
            picasso.load(movie.moviePoster).into(bimg)

            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()
        }


    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MainViewHolder(val binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {

}