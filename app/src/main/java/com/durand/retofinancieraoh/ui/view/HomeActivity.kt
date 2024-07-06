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
import com.durand.retofinancieraoh.core.RetrofitHelper
import com.durand.retofinancieraoh.data.model.MovieModel
import com.durand.retofinancieraoh.data.model.MovieListModel
import com.durand.retofinancieraoh.databinding.ActivityHomeBinding
import com.durand.retofinancieraoh.ui.viewModel.HomeMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val quoteViewModel: HomeMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //quoteViewModel.onCreate()
//        quoteViewModel.quoteModel.observe(this, Observer {
//            Log.d("josue", "it.image")
//            Log.d("josue", it.image)
//        })


    }

    private fun showData(data: List<MovieModel>){
    }
}