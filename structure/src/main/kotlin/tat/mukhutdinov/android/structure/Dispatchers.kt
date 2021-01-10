@file:Suppress("PropertyName")

package tat.mukhutdinov.android.structure
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Use Dispatchers provided by the interface to easily mock them during tests
 */
interface Dispatchers {

    val Main: CoroutineDispatcher

    val IO: CoroutineDispatcher

    val Default: CoroutineDispatcher
}