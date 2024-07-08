package com.durand.retofinancieraoh.ui.candy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.durand.retofinancieraoh.data.response.candy.CandyMasterResponse
import com.durand.retofinancieraoh.data.response.candy.CandyResponse
import com.durand.retofinancieraoh.databinding.FragmentDashboardBinding
import com.durand.retofinancieraoh.ui.adapter.CandyRecyclerAdapter
import com.durand.retofinancieraoh.ui.adapter.MovieRecyclerAdapter
import com.durand.retofinancieraoh.ui.viewModel.CandyStoreViewModel
import com.durand.retofinancieraoh.ui.viewModel.HomeMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CandyStoreFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val candyStoreViewModel: CandyStoreViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        candyStoreViewModel.showCandyStore()
        candyStoreViewModel.candyModel.observe(viewLifecycleOwner) {
            showCandyStore(it.data)
        }
    }

    private fun showCandyStore(data: List<CandyResponse>) {
        Log.d("josue", data.toString())
        binding.candyRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.candyRecyclerView.adapter = CandyRecyclerAdapter(data, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}