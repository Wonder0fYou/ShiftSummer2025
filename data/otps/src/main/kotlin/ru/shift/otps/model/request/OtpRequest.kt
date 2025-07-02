package ru.shift.otps.model.request

import com.google.gson.annotations.SerializedName

data class OtpRequest(
    @SerializedName("phone")
    val phone: String
)
