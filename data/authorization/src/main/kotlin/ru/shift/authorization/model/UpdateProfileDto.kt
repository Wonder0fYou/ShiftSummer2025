package ru.shift.authorization.model

import com.google.gson.annotations.SerializedName

data class UpdateProfileDto(
    @SerializedName("firstname")
    val firstname: String?,
    @SerializedName("middlename")
    val middlename: String?,
    @SerializedName("lastname")
    val lastname: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("city")
    val city: String?
)
