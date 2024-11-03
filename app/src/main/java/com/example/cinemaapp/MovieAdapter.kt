package com.example.cinemaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaapp.Movie
import com.example.cinemaapp.R

class MovieAdapter(
    private val movieList: List<Movie>,
    private val onItemClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.textViewTitle)
        val posterImage: ImageView = view.findViewById(R.id.imageViewPoster)

        init {
            view.setOnClickListener {
                onItemClick(movieList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.title.text = movie.title
        holder.posterImage.setImageResource(movie.posterImage)
        holder.itemView.findViewById<TextView>(R.id.textViewDuration).text = movie.duration
        holder.itemView.findViewById<TextView>(R.id.textViewRating).text = movie.rating
    }

    override fun getItemCount(): Int = movieList.size
}
