package tat.mukhutdinov.android.structure.sample.usersList.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.android.structure.recycler.BaseAdapter
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.usersList.ui.boundary.UsersListBindings

class UsersListAdapter(
    bindings: UsersListBindings
) : BaseAdapter<User, UsersListBindings, UsersListItemViewHolder>(bindings) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListItemViewHolder =
        UsersListItemViewHolder.create(parent)

    override fun getDiffUtil(updated: List<User>): DiffUtil.Callback =
        UserDiffUtil(items, updated)

    override fun getItemId(position: Int): Long =
        items[position].id.toLong()
}