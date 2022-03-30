package com.example.rickandmortyaapp.ui.fragments.episode

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyaapp.common.base.BaseFragment
import com.example.rickandmortyaapp.R
import com.example.rickandmortyaapp.databinding.FragmentEpisodeBinding
import com.example.rickandmortyaapp.ui.adapters.EpisodeAdapter
import com.example.rickandmortyaapp.ui.adapters.pagin.LoadAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@AndroidEntryPoint
class EpisodeFragment : BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>(
    R.layout.fragment_episode
) {
    override val viewModel: EpisodeViewModel by viewModels()
    override val binding by viewBinding(FragmentEpisodeBinding::bind)

    private val episodeAdapter = EpisodeAdapter(

    )

    override fun initialize() {
        setupCharacterRecycler()
    }

    private fun setupCharacterRecycler() = with(binding) {
        rvEpisodes.layoutManager = LinearLayoutManager(requireActivity())
        rvEpisodes.adapter = episodeAdapter.withLoadStateFooter(
            LoadAdapter {
                episodeAdapter.retry()
            }
        )

        episodeAdapter.addLoadStateListener { loadStates ->
            rvEpisodes.isVisible = loadStates.refresh is LoadState.NotLoading
            progressBar.isVisible = loadStates.refresh is LoadState.Loading
            swipeRefresh.isRefreshing = loadStates.refresh is LoadState.Loading
        }


        swipeRefresh.setOnRefreshListener {
            episodeAdapter.refresh()
        }
    }

    override fun setupRequests() {
        viewModel.fetchEpisode().observe(requireActivity()) {
            this.lifecycleScope.launch {
                episodeAdapter.submitData(it)
            }
        }
    }




}