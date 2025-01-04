package com.pliniodev.features.dogs.di

import com.pliniodev.core.network.InjectionTags
import com.pliniodev.features.dogs.data.DogsApiGateway
import com.pliniodev.features.dogs.data.DogsRepositoryImpl
import com.pliniodev.features.dogs.domain.DogsRepository
import com.pliniodev.features.dogs.ui.screens.home.DogsHomeScreenModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val dogsModule = module {
    
    // retrofit
    single {
        val retrofit: Retrofit = get(named(InjectionTags.dogsRetrofit))
        retrofit.create(DogsApiGateway::class.java)
    }
    
    // repository
    factory<DogsRepository> { DogsRepositoryImpl(dogsApi = get()) }
    
    // screen model
    factory { DogsHomeScreenModel(repository = get()) }
}