package tat.mukhutdinov.android.structure.sample.infrastructure

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tat.mukhutdinov.android.structure.Dispatchers
import tat.mukhutdinov.android.structure.sample.infrastructure.util.AppDispatchers


object InfrastructureModule {

    val module = module {

        single<Dispatchers> {
            AppDispatchers()
        }

        single {
            Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}