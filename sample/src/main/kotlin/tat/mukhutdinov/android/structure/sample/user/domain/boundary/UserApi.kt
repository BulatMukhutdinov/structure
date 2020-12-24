package tat.mukhutdinov.android.structure.sample.user.domain.boundary

import retrofit2.http.GET
import tat.mukhutdinov.android.structure.sample.user.domain.data.dto.UserDto

interface UserApi {

    @GET("users")
    suspend fun fetchUsersList(): List<UserDto>
}