package tat.mukhutdinov.android.structure

import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigatorExtras

sealed class Navigation {

    class To(val directions: NavDirections, val extras: Navigator.Extras = FragmentNavigatorExtras()) : Navigation()

    object Up : Navigation()
}