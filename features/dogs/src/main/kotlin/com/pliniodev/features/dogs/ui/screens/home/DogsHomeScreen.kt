package com.pliniodev.features.dogs.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.pliniodev.xpimprover.common.components.FullAsyncImage
import com.pliniodev.xpimprover.common.components.Progress
import com.pliniodev.xpimprover.common.components.uiState.UiState

class DogsHomeScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<DogsHomeScreenModel>()
        val state by screenModel.state.collectAsState()
        
        LaunchedEffect(screenModel) {
            screenModel.loadHome()
        }
        
        when (val currentState = state) {
            is UiState.Loading -> Progress(modifier = Modifier.fillMaxSize())
            is UiState.Content -> {
                DogsHomeContent(currentState.data.dogs)
            }
        }
    }

     @Composable
    private fun DogsHomeContent(dogs: List<String>) {
         LazyColumn {
             items(dogs) { dog ->
                 FullAsyncImage(url = dog)
             }
         }
    }
}