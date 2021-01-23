package tat.mukhutdinov.android.structure.sample.usersList.ui.boundary

import androidx.lifecycle.LiveData
import tat.mukhutdinov.android.structure.StructureViewModel
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.usersList.ui.recycler.UsersListAdapter

abstract class UsersListViewModel : StructureViewModel() {

    abstract val users: LiveData<List<User>>

    abstract fun createAdapter(): UsersListAdapter
}