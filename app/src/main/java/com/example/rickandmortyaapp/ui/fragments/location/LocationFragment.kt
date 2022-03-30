package com.example.rickandmortyaapp.ui.fragments.location

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyaapp.common.base.BaseFragment
import com.example.rickandmortyaapp.R
import com.example.rickandmortyaapp.databinding.FragmentLocationBinding
import com.example.rickandmortyaapp.ui.adapters.LocationAdapter
import com.example.rickandmortyaapp.ui.adapters.pagin.LoadAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationFragment : BaseFragment<LocationViewModel, FragmentLocationBinding>(
    R.layout.fragment_location
) {
    override val viewModel: LocationViewModel by viewModels()
    override val binding by viewBinding(FragmentLocationBinding::bind)
    private val locationAdapter = LocationAdapter(

    )

    override fun initialize() {
        setupCharacterRecycler()
    }

    private fun setupCharacterRecycler() = with(binding) {
        rvLocations.layoutManager = LinearLayoutManager(requireActivity())
        rvLocations.adapter = locationAdapter.withLoadStateFooter(
            LoadAdapter {
                locationAdapter.retry()
            })

        locationAdapter.addLoadStateListener { loadStates ->
            rvLocations.isVisible = loadStates.refresh is LoadState.NotLoading
            progressBar.isVisible = loadStates.refresh is LoadState.Loading
            swipeRefresh.isRefreshing = loadStates.refresh is LoadState.Loading
        }

        swipeRefresh.setOnRefreshListener {
            locationAdapter.refresh()
        }
    }

    override fun setupRequests() {
        viewModel.fetchLocations().observe(requireActivity()) {
            this.lifecycleScope.launch {
                locationAdapter.submitData(it)
            }
        }
    }


}