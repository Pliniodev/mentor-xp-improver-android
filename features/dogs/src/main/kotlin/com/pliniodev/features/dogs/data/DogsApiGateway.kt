package com.pliniodev.features.dogs.data

import com.pliniodev.features.dogs.data.response.DogsResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface DogsApiGateway {
    @GET("breed/{breedName}/images")
    suspend fun getDogs(
        @Path("breedName") breedName: String,
    ): DogsResponse
}