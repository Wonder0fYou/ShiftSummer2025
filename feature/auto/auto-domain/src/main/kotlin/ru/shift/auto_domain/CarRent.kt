package ru.shift.auto_domain

data class CarRent(
    val success: Boolean,
    val reason: String?,
    val carInfo: Cars,
    val status: Int,
    val pickupLocation: String,
    val returnLocation: String,
    val startDate: Int,
    val endDate: Int,
    val totalPrice: Int,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val birthDate: String,
    val email: String,
    val phone: String,
    val comment: String?
)
