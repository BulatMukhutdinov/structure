package tat.mukhutdinov.android.structure.sample.user.domain.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
class User(val id: Int, val login: String, val url: String?) : Parcelable