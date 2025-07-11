package ru.shift.auto_impl.screen.booking.controller.state

data class BookingData(
    val carId: String? = null,
    val pickupLocation: String? = null,
    val returnLocation: String? = null,
    val startDate: Int? = null,
    val endDate: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val middleName: String? = null,
    val birthDate: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val comment: String? = null
)
