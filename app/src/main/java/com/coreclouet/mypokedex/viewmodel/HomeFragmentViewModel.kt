package com.coreclouet.mypokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coreclouet.domain.interaction.GetGenerationListUseCase
import com.coreclouet.domain.interaction.GetPokemonListUseCase
import com.coreclouet.domain.interaction.GetVersionGroupListUseCase
import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.model.Generation
import com.coreclouet.domain.model.Pokemon
import com.coreclouet.domain.model.Version
import com.coreclouet.domain.model.VersionGroup
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
            val generations: List<Generation>? = getGenerationListUseCase()
            println("generations: ${generations?.size}")
            generations?.forEach {
                //println(it.toString())
            }

            val versionsGroups: List<VersionGroup>? = getVersionGroupListUseCase()
            println("versionsGroups: ${versionsGroups?.size}")
            versionsGroups?.forEach {
                //println(it.toString())
            }

            val versions: List<Version>? = getVersionListUseCase()
            println("versions: ${versions?.size}")
            versions?.forEach {
                //println(it.toString())
            }

            val pokemons: List<Pokemon>? = getPokemonListUseCase()
            println("pokemons: ${pokemons?.size}")
            pokemons?.forEach {
                //println(it.toString())
            }
        }
    }

}