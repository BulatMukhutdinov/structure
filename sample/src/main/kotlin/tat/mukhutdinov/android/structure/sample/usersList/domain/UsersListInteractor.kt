package tat.mukhutdinov.android.structure.sample.usersList.domain

import tat.mukhutdinov.android.structure.sample.user.domain.boundary.UserApi
import tat.mukhutdinov.android.structure.sample.user.domain.data.UserConverter
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.usersList.domain.boundary.UsersListDomain

class UsersListInteractor(private val api: UserApi, private val converter: UserConverter) : UsersListDomain {

    override suspend fun getUsers(): List<User> =
        api.fetchUsersList()
            .map(converter::toModel)
}