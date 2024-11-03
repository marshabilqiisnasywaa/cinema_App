package com.example.cinemaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cinemaapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewMovies = findViewById<RecyclerView>(R.id.recyclerViewMovies)
        recyclerViewMovies.layoutManager = GridLayoutManager(this, 2)

        val movieList = listOf(
            Movie("Venom: The Last Dance", "1 h 49 m", "R13+", R.drawable.venom, "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating","action"),
            Movie("DOSA MUSYRIK", "1 h 32 m", "D17+", R.drawable.dosa, "Synopsis for DOSA MUSYRIK ...", "horror"),
            Movie("Inside Out 2", "1 h 36 m", "SU", R.drawable.inside, "Synopsis for Inside Out 2 ...","comedy"),
            Movie("Transformer One", "1 h 44 m", "R13+", R.drawable.transformer, "Synopsis for Transformer One ...","action")
        )

        val movieAdapter = MovieAdapter(movieList) { movie ->
            val intent = Intent(this, MovieDetailActivity::class.java).apply {
                putExtra("title", movie.title)
                putExtra("duration", movie.duration)
                putExtra("rating", movie.rating)
                putExtra("synopsis", movie.synopsis)
                putExtra("genre", movie.genre)
                putExtra("posterImage", movie.posterImage)
            }
            startActivity(intent)
        }

        recyclerViewMovies.adapter = movieAdapter
    }
}
