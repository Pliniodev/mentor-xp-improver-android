package com.pliniodev.features.dogs.di

import com.pliniodev.features.dogs.data.DogsApiGateway
import com.pliniodev.features.dogs.data.DogsRepositoryImpl
import com.pliniodev.features.dogs.domain.DogsRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val dogsModule = module {
    
    // retrofit
    single {
        val retrofit: Retrofit = get()
        retrofit.create(DogsApiGateway::class.java)
    }
    
    // repository
    factory<DogsRepository> { DogsRepositoryImpl(dogsApi = get()) }
}