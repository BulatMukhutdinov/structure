@file:Suppress("PropertyName")

package tat.mukhutdinov.android.structure
import kotlinx.coroutines.CoroutineDispatcher

interface Dispatchers {

    val Main: CoroutineDispatcher

    val IO: CoroutineDispatcher

    val Default: CoroutineDispatcher
}