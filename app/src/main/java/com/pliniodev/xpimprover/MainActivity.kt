package com.pliniodev.xpimprover

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.pliniodev.xpimprover.common.theme.XpImproverTheme
import com.pliniodev.xpimprover.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XpImproverTheme {
                Navigator(HomeScreen)
            }
        }
    }
}