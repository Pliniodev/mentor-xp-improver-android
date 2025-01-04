package com.pliniodev.features.dogs.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel

class DogsHomeScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<DogsHomeScreenModel>()
        val state by screenModel.state.collectAsState()
        
        LaunchedEffect(screenModel) {
            screenModel.loadHome()
        }
        
        when (val currentState = state) {
            is UiState.Loading -> {
                Text(text = "Loading")
            }
            is UiState.Content -> {
                DogsHomeContent(currentState.data.dogs)
            }
        }
    }

     @Composable
    private fun DogsHomeContent(dogs: List<String>) {
         LazyColumn {
             items(dogs) { dog ->
                 Text(text = dog)
             }
         }
    }
}