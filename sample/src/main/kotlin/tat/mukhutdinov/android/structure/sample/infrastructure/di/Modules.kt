package tat.mukhutdinov.android.structure.sample.infrastructure.di

import tat.mukhutdinov.android.structure.sample.infrastructure.InfrastructureModule
import tat.mukhutdinov.android.structure.sample.user.UserModule
import tat.mukhutdinov.android.structure.sample.usersList.UsersListModule


object Modules {

    val modules = listOf(
        UserModule.module,
        UsersListModule.module,
        InfrastructureModule.module,
    )
}