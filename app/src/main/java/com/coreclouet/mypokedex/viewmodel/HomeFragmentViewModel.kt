package com.coreclouet.mypokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coreclouet.domain.interaction.GetGenerationListUseCase
import com.coreclouet.domain.interaction.GetPokemonListUseCase
import com.coreclouet.domain.interaction.GetVersionGroupListUseCase
import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.model.Pokemon
import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val getVersionListUseCase: GetVersionListUseCase,
    private val getVersionGroupListUseCase: GetVersionGroupListUseCase,
    private val getGenerationListUseCase: GetGenerationListUseCase,
    private val getPokemonListUseCase: GetPokemonListUseCase
) :
    ViewModel() {

    fun getVersions() {
        viewModelScope.launch {
/*            val generations: List<Generation>? = getGenerationListUseCase()
            generations?.forEach {
                println(it.toString())
            }

            val versionsGroups: List<VersionGroup>? = getVersionGroupListUseCase()
            versionsGroups?.forEach {
                println(it.toString())
            }

            val versions: List<Version>? = getVersionListUseCase()
            versions?.forEach {
                println(it.toString())
            }*/

            val pokemons: List<Pokemon>? = getPokemonListUseCase()
            pokemons?.forEach {
                println(it.toString())
            }
        }
    }

}