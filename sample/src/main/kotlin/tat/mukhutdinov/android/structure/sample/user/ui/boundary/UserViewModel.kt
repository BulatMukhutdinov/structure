package tat.mukhutdinov.android.structure.sample.user.ui.boundary

import android.net.Uri
import androidx.lifecycle.LiveData
import tat.mukhutdinov.android.structure.StructureViewModel

abstract class UserViewModel : StructureViewModel() {

    abstract val openUrl: LiveData<Uri>
}