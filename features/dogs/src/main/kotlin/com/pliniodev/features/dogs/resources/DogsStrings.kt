package com.pliniodev.features.dogs.resources

import cafe.adriel.lyricist.LyricistStrings

data class DogsStrings(
    val title: String = "Dogs",
)

@LyricistStrings(languageTag = "pt", default = true)
val strings = DogsStrings()