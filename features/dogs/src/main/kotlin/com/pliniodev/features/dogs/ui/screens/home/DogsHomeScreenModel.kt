package com.pliniodev.features.dogs.ui.screens.home

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.pliniodev.features.dogs.domain.DogsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class DogsState(val dogs: List<String> = emptyList())

internal class DogsHomeScreenModel(
    private val repository: DogsRepository,
) : StateScreenModel<UiState<DogsState>>(UiState.Loading) {
    
    fun loadHome() {
        screenModelScope.launch {
            val dogs = repository.getDogs("affenpinscher")
            
            mutableState.value = UiState.Content(DogsState(dogs.imageUrl))
        }
    }
}