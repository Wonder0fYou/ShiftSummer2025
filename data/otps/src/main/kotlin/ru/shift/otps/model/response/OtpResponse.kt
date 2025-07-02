package ru.shift.otps.model.response

import com.google.gson.annotations.SerializedName

data class OtpResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("retryDelay")
    val retryDelay: Int
)
