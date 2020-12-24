package tat.mukhutdinov.android.structure.sample.usersList.ui.boundary

import androidx.lifecycle.LiveData
import tat.mukhutdinov.android.structure.StructureViewModel
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.usersList.ui.recycler.UsersListAdapter

interface UsersListViewModel : StructureViewModel {

    val users: LiveData<List<User>>

    fun createAdapter(): UsersListAdapter
}