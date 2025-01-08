package com.pliniodev.xpimprover.features.userDbCrud.ui

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.pliniodev.xpimprover.common.components.uiState.UiState
import com.pliniodev.xpimprover.core.database.domain.User
import com.pliniodev.xpimprover.features.userDbCrud.domain.UserCrudUseCase
import kotlinx.coroutines.launch

internal data class UserCrudState(
    val registeredUser: User? = null
)

internal class UserCrudHomeScreenModel(
    private val useCase: UserCrudUseCase,
) : StateScreenModel<UiState<UserCrudState>>(UiState.Content(UserCrudState())) {

    fun insertUser(
        name: String,
        email: String,
    ) {
        screenModelScope.launch {
            mutableState.value = UiState.Loading
            val user = User(name, email)
            useCase.insertUser(user)
            val registeredUser = useCase.getUserByName(user.name)
            registeredUser?.let {
                mutableState.value = UiState.Content(UserCrudState(registeredUser))
            }
        }
    }
}