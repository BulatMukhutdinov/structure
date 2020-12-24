package tat.mukhutdinov.android.structure.sample.usersList.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import tat.mukhutdinov.android.structure.recycler.BaseViewHolder
import tat.mukhutdinov.android.structure.sample.R
import tat.mukhutdinov.android.structure.sample.databinding.UsersListItemBinding
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.usersList.ui.boundary.UsersListBindings

class UsersListItemViewHolder(
    viewBinding: UsersListItemBinding
) : BaseViewHolder<User, UsersListBindings, UsersListItemBinding>(viewBinding) {

    companion object {

        fun create(parent: ViewGroup): UsersListItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewDataBinding: UsersListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.users_list_item, parent, false)

            return UsersListItemViewHolder(viewDataBinding)
        }
    }
}