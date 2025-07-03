package ru.shift.cars.model.response

import ru.shift.cars.model.RentsDto

data class CarRentsResponse(
    val success: Boolean,
    val reason: String?,
    val rents: List<RentsDto>
)
