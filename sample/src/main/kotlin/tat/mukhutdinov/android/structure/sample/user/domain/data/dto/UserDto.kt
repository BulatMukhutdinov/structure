package tat.mukhutdinov.android.structure.sample.user.domain.data.dto

import com.google.gson.annotations.SerializedName

class UserDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("login")
    val login: String?,
    @SerializedName("url")
    val url: String?,
)