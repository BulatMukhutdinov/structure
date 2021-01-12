package tat.mukhutdinov.android.structure.sample.user

import org.koin.dsl.module
import retrofit2.Retrofit
import tat.mukhutdinov.android.structure.sample.user.domain.UserInteractor
import tat.mukhutdinov.android.structure.sample.user.domain.boundary.UserApi
import tat.mukhutdinov.android.structure.sample.user.domain.boundary.UserDomain
import tat.mukhutdinov.android.structure.sample.user.domain.data.UserConverter
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.user.ui.UserRetainedViewModel
import tat.mukhutdinov.android.structure.sample.user.ui.boundary.UserViewModel
import tat.mukhutdinov.android.structure.structureViewModel

object UserModule {

    val module = module {

        structureViewModel<UserViewModel> { (user: User) ->
            UserRetainedViewModel(user)
        }

        factory<UserDomain> {
            UserInteractor()
        }

        factory {
            val retrofit: Retrofit = get()

            retrofit.create(UserApi::class.java)
        }

        factory {
            UserConverter()
        }
    }
}