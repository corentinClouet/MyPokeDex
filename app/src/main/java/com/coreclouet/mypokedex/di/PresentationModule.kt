package com.coreclouet.mypokedex.di

import com.coreclouet.mypokedex.viewmodel.HomeFragmentViewModel
import com.coreclouet.mypokedex.viewmodel.PokedexFragmentViewModel
import com.coreclouet.mypokedex.viewmodel.PokemonFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeFragmentViewModel(getVersionListUseCase = get(), getVersionUseCase = get()) }
    viewModel { PokedexFragmentViewModel() }
    viewModel { PokemonFragmentViewModel() }
}