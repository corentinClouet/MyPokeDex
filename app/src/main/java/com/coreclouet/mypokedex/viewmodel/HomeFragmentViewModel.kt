package com.coreclouet.mypokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.interaction.GetVersionUseCase
import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val getVersionListUseCase: GetVersionListUseCase,
    private val getVersionUseCase: GetVersionUseCase
) :
    ViewModel() {

    fun getVersions() {
        viewModelScope.launch {
            val result: List<String>? = getVersionListUseCase.invoke()
            result?.forEach {
                getVersionDetail(it)
            }
        }
    }

    private fun getVersionDetail(name: String) {
        viewModelScope.launch {
            getVersionUseCase(name)
        }
    }

}