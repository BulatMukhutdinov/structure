package tat.mukhutdinov.android.structure.sample.usersList

import org.koin.dsl.module
import tat.mukhutdinov.android.structure.sample.usersList.domain.UsersListInteractor
import tat.mukhutdinov.android.structure.sample.usersList.domain.boundary.UsersListDomain
import tat.mukhutdinov.android.structure.sample.usersList.ui.UsersListRetainedViewModel
import tat.mukhutdinov.android.structure.sample.usersList.ui.boundary.UsersListViewModel
import tat.mukhutdinov.android.structure.structureViewModel

object UsersListModule {

    val module = module {

        structureViewModel<UsersListViewModel> {
            UsersListRetainedViewModel(get())
        }

        factory<UsersListDomain> {
            UsersListInteractor(get(), get())
        }
    }
}