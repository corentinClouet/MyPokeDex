package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.PokemonRepository

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(name: String) = pokemonRepository.getPokemon(name)
}