package ru.shift.otps.api

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST
import ru.shift.otps.model.request.OtpRequest
import ru.shift.otps.model.response.OtpResponse
import ru.shift.remote.api.BaseRemoteApi

interface OtpsRemoteApi: BaseRemoteApi{
    @POST("${API_AUTH}/otp")
    suspend fun postOtp(
        @Body otpRequest: OtpRequest
    ): ApiResponse<OtpResponse>

    companion object {
        private const val API_AUTH = "/api/auth"
    }
}