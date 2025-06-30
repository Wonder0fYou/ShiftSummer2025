package ru.shift.authorization.model.request

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("code")
    val code: Int
)
