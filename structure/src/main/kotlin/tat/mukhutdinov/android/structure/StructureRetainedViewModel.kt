package tat.mukhutdinov.android.structure

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import org.koin.android.viewmodel.dsl.setIsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent
import org.koin.core.definition.BeanDefinition
import org.koin.core.definition.Definition
import org.koin.core.inject
import org.koin.core.module.Module
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.TypeQualifier
import tat.mukhutdinov.android.utils.SingleLiveData
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

abstract class StructureRetainedViewModel : ViewModel(), KoinComponent, CoroutineScope, StructureViewModel {

    private val dispatchers: Dispatchers by inject()

    private val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
        handleCoroutineException(context, throwable)
    }

    override val coroutineContext: CoroutineContext = SupervisorJob() + dispatchers.IO + exceptionHandler

    override val navigation = SingleLiveData<Navigation>()

    open fun handleCoroutineException(context: CoroutineContext, throwable: Throwable) {
        Timber.e(throwable)
    }

    override fun onCleared() {
        super.onCleared()

        cancel()
    }
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any> Fragment.viewModel(noinline parameters: ParametersDefinition? = null): Lazy<T> {
    val viewModel = viewModel<ViewModel>(TypeQualifier(T::class), parameters)

    return viewModel as Lazy<T>
}

inline fun <reified T> Module.viewModel(override: Boolean = false, noinline definition: Definition<ViewModel>): BeanDefinition<ViewModel> {
    val beanDefinition = factory(TypeQualifier(T::class), override, definition)
    beanDefinition.setIsViewModel()
    return beanDefinition
}