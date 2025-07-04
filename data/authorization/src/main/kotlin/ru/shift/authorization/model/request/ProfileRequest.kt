package ru.shift.authorization.model.request

import com.google.gson.annotations.SerializedName
import ru.shift.authorization.model.UpdateProfileDto

data class ProfileRequest(
    @SerializedName("profile")
    val profile: UpdateProfileDto,
    @SerializedName("phone")
    val phone: String
)
