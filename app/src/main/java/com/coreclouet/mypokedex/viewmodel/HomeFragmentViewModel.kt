package com.coreclouet.mypokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coreclouet.domain.interaction.GetGenerationListUseCase
import com.coreclouet.domain.interaction.GetVersionGroupListUseCase
import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.model.Generation
import com.coreclouet.domain.model.Version
import com.coreclouet.domain.model.VersionGroup
import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val getVersionListUseCase: GetVersionListUseCase,
    private val getVersionGroupListUseCase: GetVersionGroupListUseCase,
    private val getGenerationListUseCase: GetGenerationListUseCase
) :
    ViewModel() {

    fun getVersions() {
        viewModelScope.launch {
            val generations: List<Generation>? = getGenerationListUseCase()
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
            }
        }
    }

}