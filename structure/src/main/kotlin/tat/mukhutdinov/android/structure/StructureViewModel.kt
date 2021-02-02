package tat.mukhutdinov.android.structure

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tat.mukhutdinov.android.utils.SingleLiveData
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

abstract class StructureViewModel : ViewModel(), KoinComponent, CoroutineScope {

    val navigation = SingleLiveData<Navigation>()

    protected val dispatchers: Dispatchers by inject()

    private val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
        handleCoroutineException(context, throwable)
    }

    override val coroutineContext: CoroutineContext = SupervisorJob() + dispatchers.IO + exceptionHandler

    open fun handleCoroutineException(context: CoroutineContext, throwable: Throwable) {
        Timber.e(throwable)
    }

    override fun onCleared() {
        super.onCleared()

        cancel()
    }
}