package com.pliniodev.xpimprover.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.pliniodev.xpimprover.common.components.Button
import com.pliniodev.xpimprover.common.theme.CustomSpacing
import com.pliniodev.xpimprover.navigation.SharedScreen

internal object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val postListScreen = rememberScreen(SharedScreen.FeatureHome)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(CustomSpacing.medium),
        ) {
            Button(
                text = "Feature Dogs",
                modifier = Modifier.fillMaxWidth(),
            ) {
                navigator.push(postListScreen)
            }
        }
    }
}