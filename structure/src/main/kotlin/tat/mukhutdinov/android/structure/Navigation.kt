package tat.mukhutdinov.android.structure

import androidx.navigation.NavDirections

sealed class Navigation {

    class To(val directions: NavDirections) : Navigation()

    object Up : Navigation()
}