package tat.mukhutdinov.android.structure.sample.usersList.domain.boundary

import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User

interface UsersListDomain {

    suspend fun getUsers(): List<User>
}