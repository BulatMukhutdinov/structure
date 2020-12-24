package tat.mukhutdinov.android.structure

import androidx.lifecycle.LiveData

interface StructureViewModel {

    val navigation: LiveData<Navigation>
}