package ru.shift.authorization.api

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import ru.shift.authorization.model.request.ProfileRequest
import ru.shift.authorization.model.request.SignInRequest
import ru.shift.authorization.model.response.ProfileResponse
import ru.shift.remote.api.BaseRemoteApi

interface AuthorizationRemoteApi : BaseRemoteApi {

    @POST("${API_USERS}/signin")
    suspend fun postSignIn(
        @Body signInRequest: SignInRequest
    ): ApiResponse<ProfileResponse>

    @PATCH("$API_USERS/profile")
    suspend fun patchProfile(
        @Body profileRequest: ProfileRequest
    ): ApiResponse<ProfileResponse>

    @GET("$API_USERS/session")
    suspend fun getProfile(): ApiResponse<ProfileResponse>

    companion object {
        private const val API_USERS = "/api/users"
    }
}