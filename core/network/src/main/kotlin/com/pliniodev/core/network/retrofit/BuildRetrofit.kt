package com.pliniodev.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

internal class BuildRetrofit(private val json: Json) {
    fun build(apiBaseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        with(Retrofit.Builder()) {
            baseUrl(apiBaseUrl)
            client(okHttpClient)
            addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            build()
        }
}