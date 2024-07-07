package com.durand.retofinancieraoh.ui.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.durand.retofinancieraoh.R
import com.durand.retofinancieraoh.data.model.MovieResponse
import com.durand.retofinancieraoh.data.response.banner.BannerMovieResponse
import com.durand.retofinancieraoh.data.response.peli.MovieMasterResponse
import com.durand.retofinancieraoh.data.response.peli.PeliMovieResponse
import com.durand.retofinancieraoh.databinding.ActivityHomeBinding
import com.durand.retofinancieraoh.ui.adapter.BannerViewPagerAdapter
import com.durand.retofinancieraoh.ui.adapter.MovieRecyclerAdapter
import com.durand.retofinancieraoh.ui.viewModel.HomeMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Call

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeMovieViewModel: HomeMovieViewModel by viewModels()
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback
    private val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {
        override fun run() {
            val currentItem = binding.movieViewPager2.currentItem
            val itemCount = binding.movieViewPager2.adapter?.itemCount ?: 0
            val nextItem = (currentItem + 1) % itemCount
            binding.movieViewPager2.currentItem = nextItem
            handler.postDelayed(this, 2000)
        }
    }

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }

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
        homeMovieViewModel.showBanner()
        homeMovieViewModel.bannerModel.observe(this) {
            showBanner(it.data)
        }

        homeMovieViewModel.showPeli()
        homeMovieViewModel.movieModel.observe(this) {
            showMovieDefault(it.data)
            binding.movieProgressBar.visibility = View.GONE
            binding.categoryProgressBar.visibility = View.GONE
            binding.nextMovieProgressBar.visibility = View.GONE
        }
    }

    private fun showMovieDefault(data: List<PeliMovieResponse>) {
        Log.d("josue", "showMovieDefault")
        Log.d("josue", "title: $data")
        // Movie
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.movieRecyclerView.adapter = MovieRecyclerAdapter(data, this)
        // Category
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRecyclerView.adapter = MovieRecyclerAdapter(data, this)
        // Next Movie
        binding.nextMovieRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.nextMovieRecyclerView.adapter = MovieRecyclerAdapter(data, this)
    }


    private fun showBanner(data: List<BannerMovieResponse>) {
        val adapter = BannerViewPagerAdapter(data, this)
        binding.movieViewPager2.adapter = adapter
        handler.postDelayed(runnable, 2000)

        val slideDotLL = findViewById<LinearLayout>(R.id.slideDotLL)
        val dotsImage = Array(data.size) { ImageView(this) }

        dotsImage.forEach {
            it.setImageResource(
                R.drawable.non_active_dot
            )
            slideDotLL.addView(it, params)
        }

        // default first dot selected
        dotsImage[0].setImageResource(R.drawable.active_dot)
        pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dotsImage.mapIndexed { index, imageView ->
                    if (position == index) {
                        imageView.setImageResource(
                            R.drawable.active_dot
                        )
                    } else {
                        imageView.setImageResource(R.drawable.non_active_dot)
                    }
                }
                super.onPageSelected(position)
            }
        }
        binding.movieViewPager2.registerOnPageChangeCallback(pageChangeListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
        binding.movieViewPager2.unregisterOnPageChangeCallback(pageChangeListener)
    }
}