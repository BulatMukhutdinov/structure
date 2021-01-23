package tat.mukhutdinov.android.structure.sample.usersList

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tat.mukhutdinov.android.structure.sample.usersList.domain.UsersListInteractor
import tat.mukhutdinov.android.structure.sample.usersList.domain.boundary.UsersListDomain
import tat.mukhutdinov.android.structure.sample.usersList.ui.UsersListRetainedViewModel
import tat.mukhutdinov.android.structure.sample.usersList.ui.boundary.UsersListViewModel

object UsersListModule {

    val module = module {

        viewModel<UsersListViewModel> {
            UsersListRetainedViewModel(get())
        }

        factory<UsersListDomain> {
            UsersListInteractor(get(), get())
        }
    }
}