package ru.shift.cars.model.response

import ru.shift.cars.model.CarsDto
import ru.shift.cars.model.PaginationMetaDto

data class CarsPaginatedResponse(
    val success: Boolean,
    val reason: String?,
    val data: List<CarsDto>,
    val meta: PaginationMetaDto
)
