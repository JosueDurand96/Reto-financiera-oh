package com.durand.retofinancieraoh.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.durand.retofinancieraoh.R
import com.durand.retofinancieraoh.data.model.MovieResponse
import com.durand.retofinancieraoh.databinding.ActivityHomeBinding
import com.durand.retofinancieraoh.ui.viewModel.HomeMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val quoteViewModel: HomeMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        quoteViewModel.onCreate()
        quoteViewModel.quoteModel.observe(this, Observer {
            showBanner(it.data)
        })
    }

    private fun showBanner(data: List<MovieResponse>) {
        for (i in data) {
            Log.d("josue", "image: " + i.image)
            Log.d("josue", "name: " + i.name)
        }
        binding.movieViewPager2
    }

}