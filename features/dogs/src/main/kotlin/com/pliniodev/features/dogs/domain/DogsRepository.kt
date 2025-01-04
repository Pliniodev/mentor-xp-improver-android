package com.pliniodev.features.dogs.domain

import com.pliniodev.features.dogs.domain.model.Dogs

internal interface DogsRepository {
    suspend fun getDogs(breedName: String): Dogs
}