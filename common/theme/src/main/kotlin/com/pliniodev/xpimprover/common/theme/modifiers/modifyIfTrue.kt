package com.pliniodev.xpimprover.common.theme.modifiers

import androidx.compose.ui.Modifier

public fun Modifier.modifyIfTrue(
    condition: Boolean,
    modifier: Modifier.() -> Modifier,
): Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}