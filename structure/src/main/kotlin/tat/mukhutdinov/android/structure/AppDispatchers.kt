package tat.mukhutdinov.android.structure

class AppDispatchers : Dispatchers {

    override val Main = kotlinx.coroutines.Dispatchers.Main

    override val IO = kotlinx.coroutines.Dispatchers.IO

    override val Default = kotlinx.coroutines.Dispatchers.Default
}