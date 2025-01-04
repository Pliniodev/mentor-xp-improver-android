package com.pliniodev.features.dogs.data

import com.pliniodev.features.dogs.domain.DogsRepository
import com.pliniodev.features.dogs.domain.model.Dogs

internal class DogsRepositoryImpl(
    private val dogsApi: DogsApiGateway
): DogsRepository {
    override suspend fun getDogs(breedName: String): Dogs {
        val response = dogsApi.getDogs(breedName)
        return Dogs(imageUrl = response.imageUrl)
    }
}