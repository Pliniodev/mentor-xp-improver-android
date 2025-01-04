package com.pliniodev.features.dogs.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class DogsHomeScreen : Screen {
    @Composable
    override fun Content() {
        Text(text = "Feature Dogs Home Screen")
    }
}