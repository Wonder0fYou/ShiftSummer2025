package ru.shift.otps.api

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST
import ru.shift.otps.model.response.OtpResponse

interface OtpsRemoteApi {
    @POST("${API_AUTH}/otp")
    suspend fun postOtp(
        @Body
    ): ApiResponse<OtpResponse>

    companion object {
        private const val API_AUTH = "/api/auth"
    }
}