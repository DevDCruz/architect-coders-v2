package com.devexperto.architectcoders.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.devexperto.architectcoders.R
import com.devexperto.architectcoders.databinding.ActivityMainBinding
import com.devexperto.architectcoders.model.RemoteConnection
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        lifecycleScope.launch {
            val movies = RemoteConnection.service.listPopularMovies(getString(R.string.api_key))
            adapter.movies = movies.results
        }
    }
}