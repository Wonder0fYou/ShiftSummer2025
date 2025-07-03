package ru.shift.cars.model.response

import ru.shift.cars.model.CarWithRentsDto

data class CarResponse(
    val success: Boolean,
    val reason: String?,
    val data: CarWithRentsDto
)
