package com.example.rickandmortyaapp.ui.fragments.character

import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyaapp.common.base.BaseFragment
import com.example.rickandmortyaapp.R
import com.example.rickandmortyaapp.databinding.FragmentCharacterBinding
import com.example.rickandmortyaapp.ui.adapters.CharacterAdapter
import com.example.rickandmortyaapp.ui.adapters.pagin.LoadAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment :
    BaseFragment<CharacterViewModel, FragmentCharacterBinding>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()
    override val binding by viewBinding(FragmentCharacterBinding::bind)

    private val characterAdapter = CharacterAdapter(
        this::setOnItemLongClickListener
    )

    override fun initialize() {
        setupCharacterRecycler()
    }

    private fun setupCharacterRecycler() = with(binding) {
        rvCharacters.layoutManager = LinearLayoutManager(requireActivity())
        rvCharacters.adapter = characterAdapter.withLoadStateFooter(
            LoadAdapter {
                characterAdapter.retry()
            })

        characterAdapter.addLoadStateListener { loadStates ->
            rvCharacters.isVisible = loadStates.refresh is LoadState.NotLoading
            progressBar.isVisible = loadStates.refresh is LoadState.Loading
            swipeRefresh.isRefreshing = loadStates.refresh is LoadState.Loading

        }
        swipeRefresh.setOnRefreshListener {
            characterAdapter.refresh()
        }
    }

    override fun setupRequests() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchCharacters().collectLatest {
                this@CharacterFragment.lifecycleScope.launch {
                    characterAdapter.submitData(it)
                }
            }
        }
    }



    private fun setOnItemLongClickListener(image: String) {
        findNavController().navigate(
            CharacterFragmentDirections
                .actionCharacterFragmentToCharacterDialogFragment(image)
        )
    }
}