package com.pliniodev.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.pliniodev.core.network.BaseUrls
import com.pliniodev.core.network.InjectionTags
import com.pliniodev.core.network.retrofit.BuildRetrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

    single {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    // region dogs
    single(named(InjectionTags.dogsRetrofit)) {
        val json: Json = get()
        val client: OkHttpClient = get()
        BuildRetrofit(json)
            .build(apiBaseUrl = BaseUrls.dogCeo, client)
    }
    // endregion
    // region custom
    // examples if you need to create a custom client and retrofit
    single(named("CustomHttpClient")) {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer your-token")
                    .build()
                chain.proceed(request)
            }
            .build()
    }
    single(named("CustomRetrofit")) {
        val json: Json = get(named("DefaultJson"))
        val client: OkHttpClient = get(named("CustomHttpClient"))
        Retrofit.Builder()
            .baseUrl("https://api.custom.com/")
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    //endregion
}