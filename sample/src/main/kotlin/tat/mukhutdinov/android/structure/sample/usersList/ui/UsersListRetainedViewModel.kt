package tat.mukhutdinov.android.structure.sample.usersList.ui

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import tat.mukhutdinov.android.structure.Navigation
import tat.mukhutdinov.android.structure.StructureRetainedViewModel
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.usersList.domain.boundary.UsersListDomain
import tat.mukhutdinov.android.structure.sample.usersList.ui.boundary.UsersListBindings
import tat.mukhutdinov.android.structure.sample.usersList.ui.boundary.UsersListViewModel
import tat.mukhutdinov.android.structure.sample.usersList.ui.recycler.UsersListAdapter

class UsersListRetainedViewModel(private val domain: UsersListDomain) : StructureRetainedViewModel(), UsersListViewModel, UsersListBindings {

    override val users = MutableLiveData<List<User>>()

    init {
        launch {
            users.postValue(domain.getUsers())
        }
    }

    override fun createAdapter(): UsersListAdapter =
        UsersListAdapter(this)

    override fun onUserClicked(user: User) {
        navigation.value = Navigation.To(UsersListFragmentDirections.toUser(user))
    }
}