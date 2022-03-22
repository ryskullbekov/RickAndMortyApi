package com.example.rickandmortyaapp.data.appmodule


import com.example.rickandmortyaapp.data.network.RetrofitClient
import com.example.rickandmortyaapp.data.repository.CharacterRepository
import com.example.rickandmortyaapp.data.repository.EpisodeRepository
import com.example.rickandmortyaapp.data.repository.LocationRepository
import com.example.rickandmortyaapp.ui.fragments.character.CharacterViewModel
import com.example.rickandmortyaapp.ui.fragments.episode.EpisodeViewModel
import com.example.rickandmortyaapp.ui.fragments.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().provideCharacterApiService() }
    single { get<RetrofitClient>().provideEpisodeApiService() }
    single { get<RetrofitClient>().provideLocationApiService() }
}
val repositoriesModule = module {
    factory { CharacterRepository(get()) }
    factory { EpisodeRepository(get()) }
    factory { LocationRepository(get()) }
}

val viewModelsModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }

}