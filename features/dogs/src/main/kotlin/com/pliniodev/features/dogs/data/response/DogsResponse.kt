package com.pliniodev.features.dogs.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DogsResponse(
    @SerialName("message") val imageUrl: List<String>,
)