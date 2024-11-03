package com.example.cinemaapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cinemaapp.R

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val title = intent.getStringExtra("title")
        val duration = intent.getStringExtra("duration")
        val rating = intent.getStringExtra("rating")
        val synopsis = intent.getStringExtra("synopsis")
        val genre = intent.getStringExtra("genre")
        val posterImage = intent.getIntExtra("posterImage", 0)

        findViewById<TextView>(R.id.textViewTitle).text = title
        findViewById<TextView>(R.id.textViewDuration).text = duration
        findViewById<TextView>(R.id.textViewRating).text = rating
        findViewById<TextView>(R.id.textViewSynopsis).text = synopsis
        findViewById<TextView>(R.id.textViewGenre).text = genre
        findViewById<ImageView>(R.id.imageViewPoster).setImageResource(posterImage)
    }
}
