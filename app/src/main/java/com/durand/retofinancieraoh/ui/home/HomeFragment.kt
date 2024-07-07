package com.durand.retofinancieraoh.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.durand.retofinancieraoh.R
import com.durand.retofinancieraoh.data.response.banner.BannerMovieResponse
import com.durand.retofinancieraoh.data.response.peli.PeliMovieResponse
import com.durand.retofinancieraoh.databinding.FragmentHomeBinding
import com.durand.retofinancieraoh.ui.adapter.BannerViewPagerAdapter
import com.durand.retofinancieraoh.ui.adapter.MovieRecyclerAdapter
import com.durand.retofinancieraoh.ui.viewModel.HomeMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       // val homeMovieViewModel = ViewModelProvider(this).get(HomeMovieViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeMovieViewModel.showBanner()
        homeMovieViewModel.bannerModel.observe(viewLifecycleOwner) {
            showBanner(it.data)
        }
        homeMovieViewModel.showPeli()
        homeMovieViewModel.movieModel.observe(viewLifecycleOwner) {
            showMovieDefault(it.data)
            binding.movieProgressBar.visibility = View.GONE
            binding.categoryProgressBar.visibility = View.GONE
            binding.nextMovieProgressBar.visibility = View.GONE
        }
    }

    private fun showMovieDefault(data: List<PeliMovieResponse>) {
        // Movie
        binding.movieRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.movieRecyclerView.adapter = MovieRecyclerAdapter(data, requireContext())
        // Category
        binding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRecyclerView.adapter = MovieRecyclerAdapter(data, requireContext())
        // Next Movie
        binding.nextMovieRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.nextMovieRecyclerView.adapter = MovieRecyclerAdapter(data, requireContext())
    }


    private fun showBanner(data: List<BannerMovieResponse>) {
        val adapter = BannerViewPagerAdapter(data, requireContext())
        binding.movieViewPager2.adapter = adapter
        handler.postDelayed(runnable, 2000)

        val slideDotLL = requireActivity().findViewById<LinearLayout>(R.id.slideDotLL)
        val dotsImage = Array(data.size) { ImageView(requireContext()) }

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

    override fun onDestroyView() {
        handler.removeCallbacks(runnable)
        binding.movieViewPager2.unregisterOnPageChangeCallback(pageChangeListener)
        super.onDestroyView()
        _binding = null
    }
}