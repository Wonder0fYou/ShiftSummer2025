package ru.shift.cars.model

data class PaginationMetaDto(
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int
)
