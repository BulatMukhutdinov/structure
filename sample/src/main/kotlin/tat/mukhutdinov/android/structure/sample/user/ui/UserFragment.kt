package tat.mukhutdinov.android.structure.sample.user.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import tat.mukhutdinov.android.structure.StructureFragment
import tat.mukhutdinov.android.structure.sample.databinding.UserBinding
import tat.mukhutdinov.android.structure.sample.user.ui.boundary.UserViewModel

class UserFragment : StructureFragment<UserBinding>() {

    private val args: UserFragmentArgs by navArgs()

    override val viewModel: UserViewModel by viewModel { parametersOf(args.user) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openUrl.observe(viewLifecycleOwner) {
            startActivity(Intent(Intent.ACTION_VIEW, it))
        }
    }
}