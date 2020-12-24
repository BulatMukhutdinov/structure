package tat.mukhutdinov.android.structure.sample

import android.app.Application
import tat.mukhutdinov.android.structure.sample.infrastructure.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)

            modules(Modules.modules)
        }
    }
}