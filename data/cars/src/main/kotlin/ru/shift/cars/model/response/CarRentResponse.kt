package ru.shift.cars.model.response

import ru.shift.cars.model.CarRentDto

data class CarRentResponse(
    val success: Boolean,
    val reason: String?,
    val rent: CarRentDto
)
