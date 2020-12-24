package tat.mukhutdinov.android.structure.sample.user.domain.data

import tat.mukhutdinov.android.structure.sample.user.domain.data.dto.UserDto
import tat.mukhutdinov.android.structure.sample.user.domain.data.model.User

class UserConverter {

    fun toModel(dto: UserDto): User =
        User(
            id = dto.id ?: -1,
            login = dto.login ?: "",
            url = dto.url
        )
}