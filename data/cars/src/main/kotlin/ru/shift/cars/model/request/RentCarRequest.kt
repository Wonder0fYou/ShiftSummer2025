package ru.shift.cars.model.request

data class RentCarRequest(
    val carId: String,
    val pickupLocation: String,
    val returnLocation: String,
    val startDate: Long,
    val endDate: Long,
    val firstName: String,
    val lastName: String,
    val middleName: String? = null,
    val birthDate: String,
    val email: String,
    val phone: String,
    val comment: String? = null
)
