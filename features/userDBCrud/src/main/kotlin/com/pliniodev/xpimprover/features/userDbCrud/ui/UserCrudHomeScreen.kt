package com.pliniodev.xpimprover.features.userDbCrud.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.pliniodev.xpimprover.common.components.Button
import com.pliniodev.xpimprover.common.components.Progress
import com.pliniodev.xpimprover.common.components.uiState.UiState
import com.pliniodev.xpimprover.common.theme.CustomSpacing
import com.pliniodev.xpimprover.core.database.domain.User

internal data object UserCrudHomeScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<UserCrudHomeScreenModel>()
        val state by screenModel.state.collectAsState()
        
        when (val currentState = state) {
            is UiState.Loading -> Progress(modifier = Modifier.fillMaxSize())
            is UiState.Content -> {
                RegisterContent(
                    state = currentState.data,
                    registerUser = { name, email ->
                        screenModel.insertUser(name, email)
                    }
                )
            }
        }
    }

     @Composable
    private fun RegisterContent(
         registerUser: (String, String) -> Unit,
         state: UserCrudState
     ) {
       Column {
           UserForm(registerUser = registerUser)
           RegisteredUserDisplay(registeredUser = state.registeredUser)
       }
    }

    @Composable
    private fun UserForm(
        registerUser: (String, String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        val (name, onNameChanged) = remember { mutableStateOf("") }
        val (email, onEmailChanged) = remember { mutableStateOf("") }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = CustomSpacing.medium)
                .padding(top = CustomSpacing.xLarge)
        ) {
            TextField(
                label = { Text("Nome") },
                value = name,
                onValueChange = onNameChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = CustomSpacing.medium)
            )
            
            TextField(
                label = { Text("Email") },
                value = email,
                onValueChange = onEmailChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = CustomSpacing.medium)
            )
            Button(
                text = "Registrar usuário",
                modifier = Modifier.padding(top = CustomSpacing.medium),
            ) {
                registerUser(name, email)
            }
        }
    }

     @Composable
    private fun RegisteredUserDisplay(registeredUser: User?) {
        registeredUser?.let {
            Card(
                shape = MaterialTheme.shapes.medium,
                elevation = CardDefaults. cardElevation(1.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(CustomSpacing.medium)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(CustomSpacing.medium)
                ) {
                    Text("Usuário registrado com sucesso")
                    Text(registeredUser.name)
                    Text(registeredUser.email)
                }
            }
        }
    }
}