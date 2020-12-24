package tat.mukhutdinov.android.structure.sample.user.ui

import android.net.Uri
import tat.mukhutdinov.android.structure.Navigation
import tat.mukhutdinov.android.structure.StructureRetainedViewModel
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User
import tat.mukhutdinov.android.structure.sample.user.ui.boundary.UserBindings
import tat.mukhutdinov.android.structure.sample.user.ui.boundary.UserViewModel
import tat.mukhutdinov.android.utils.SingleLiveData

class UserRetainedViewModel(private val user: User) : StructureRetainedViewModel(), UserViewModel, UserBindings {

    override val login: String = user.login

    override val openUrl = SingleLiveData<Uri>()

    override fun onLoginClicked() {
        openUrl.value = Uri.parse(user.url)
    }

    override fun onBackClicked() {
        navigation.value = Navigation.Up
    }
}