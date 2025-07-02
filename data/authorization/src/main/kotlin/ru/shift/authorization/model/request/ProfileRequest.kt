package ru.shift.authorization.model.request

import com.google.gson.annotations.SerializedName
import ru.shift.authorization.model.UpdateProfileProfileDto

data class ProfileRequest(
    @SerializedName("profile")
    val profile: UpdateProfileProfileDto,
    @SerializedName("phone")
    val phone: String
)
