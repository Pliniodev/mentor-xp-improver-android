package com.pliniodev.features.dogs.ui.resources

import cafe.adriel.lyricist.LyricistStrings

data class DogsStrings(
    val title: String = "Dogs",
)

@LyricistStrings(languageTag = "pt", default = true)
val strings = DogsStrings()