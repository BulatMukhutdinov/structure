package tat.mukhutdinov.android.structure.sample.usersList.ui.boundary

import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User

interface UsersListBindings {

    fun onUserClicked(user: User)
}