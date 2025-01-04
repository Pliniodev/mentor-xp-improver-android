package com.pliniodev.features.dogs.data.response

import kotlinx.serialization.Serializable

@Serializable
internal data class DogsResponse(
    val imageUrl: List<String>,
)