package com.coreclouet.mypokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coreclouet.domain.interaction.GetVersionListUseCase
import com.coreclouet.domain.model.Version
import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val getVersionListUseCase: GetVersionListUseCase,
) :
    ViewModel() {

    private val _versions = MutableLiveData<List<Version>>()
    val versions: LiveData<List<Version>> = _versions

    init {
        getVersions()
    }

    private fun getVersions() {
        viewModelScope.launch {
            val versions: List<Version>? = getVersionListUseCase()
            _versions.postValue(versions ?: listOf())
        }
    }

}