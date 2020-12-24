package tat.mukhutdinov.android.structure.sample.usersList.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import tat.mukhutdinov.android.structure.recycler.Diff
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User

class UserDiffUtil(
    private val oldList: List<User>,
    private val newList: List<User>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int =
        oldList.size

    override fun getNewListSize(): Int =
        newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].login == newList[newItemPosition].login

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any =
        Diff(oldList[oldItemPosition], newList[newItemPosition])
}