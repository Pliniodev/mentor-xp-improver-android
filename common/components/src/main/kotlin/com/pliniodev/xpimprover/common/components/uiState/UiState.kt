package com.pliniodev.xpimprover.common.components.uiState

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Content<T>(val data: T) : UiState<T>()
}