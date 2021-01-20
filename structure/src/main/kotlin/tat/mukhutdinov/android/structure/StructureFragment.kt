package tat.mukhutdinov.android.structure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import tat.mukhutdinov.android.utils.autoCleared
import timber.log.Timber
import java.lang.reflect.ParameterizedType

abstract class StructureFragment<ViewBinding : ViewDataBinding> : Fragment() {

    abstract val viewModel: StructureViewModel

    var viewBinding: ViewBinding by autoCleared()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigation.observe(this) {
            when (it) {
                is Navigation.To -> navigate(it.directions)
                is Navigation.Up -> navigateUp()
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBindingClass: Class<ViewBinding> = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.first() as Class<ViewBinding>

        viewBinding = viewBindingClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
            .invoke(null, inflater, container, false) as ViewBinding

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.setVariable(BR.bindings, viewModel)

        viewBinding.lifecycleOwner = viewLifecycleOwner
    }

    open fun navigate(directions: NavDirections) {
        // Показ диалогов через navigation падает при вызове на бекграунд потоке
        activity?.runOnUiThread {
            try {
                findNavController().navigate(directions)
            } catch (exception: IllegalArgumentException) {
                Timber.w(exception)
            }
        }
    }

    open fun navigateUp() {
        if (!findNavController().popBackStack()) {
            activity?.finish()
        }
    }
}