package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.PokemonRepository

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke() = pokemonRepository.getPokemonsList()
}