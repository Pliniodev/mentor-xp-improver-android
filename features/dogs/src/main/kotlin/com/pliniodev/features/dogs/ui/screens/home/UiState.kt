package com.pliniodev.features.dogs.ui.screens.home

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Content<T>(val data: T) : UiState<T>()
}