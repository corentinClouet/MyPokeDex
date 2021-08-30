package com.coreclouet.mypokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.model.Version
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val getVersionListUseCase: GetVersionListUseCase) :
    ViewModel() {

    fun getVersions() {
        viewModelScope.launch {
            val result: List<Version>? = getVersionListUseCase()
            result?.forEach {
                println(it.toString())
            }
        }
    }

}