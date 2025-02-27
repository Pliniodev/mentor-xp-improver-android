package com.pliniodev.xpimprover.application

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.pliniodev.core.network.di.networkModule
import com.pliniodev.features.dogs.di.dogsModule
import com.pliniodev.features.dogs.di.dogsScreenModule
import com.pliniodev.xpimprover.core.database.di.databaseModule
import com.pliniodev.xpimprover.di.appModule
import com.pliniodev.xpimprover.features.userDbCrud.di.userCrudModule
import com.pliniodev.xpimprover.features.userDbCrud.di.userCrudScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class XpImproverApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@XpImproverApp)
            modules(
                appModule,
                dogsModule,
                userCrudModule,
                networkModule,
                databaseModule,
            )
        }

        ScreenRegistry {
            dogsScreenModule()
            userCrudScreenModule()
        }
    }
}