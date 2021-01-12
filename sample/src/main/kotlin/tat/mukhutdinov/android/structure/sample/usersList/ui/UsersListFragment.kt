package tat.mukhutdinov.android.structure.sample.usersList.ui

import android.os.Bundle
import android.view.View
import tat.mukhutdinov.android.structure.StructureFragment
import tat.mukhutdinov.android.structure.sample.databinding.UsersListBinding
import tat.mukhutdinov.android.structure.sample.usersList.ui.boundary.UsersListViewModel
import tat.mukhutdinov.android.structure.sample.usersList.ui.recycler.UsersListAdapter
import tat.mukhutdinov.android.structure.structureViewModel
import tat.mukhutdinov.android.utils.autoCleared

class UsersListFragment : StructureFragment<UsersListBinding>() {

    override val viewModel: UsersListViewModel by structureViewModel()

    private var adapter: UsersListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = viewModel.createAdapter()

        viewBinding.users.adapter = adapter
        viewBinding.users.setHasFixedSize(true)

        viewModel.users.observe(viewLifecycleOwner, adapter::submitList)
    }
}