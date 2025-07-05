package ru.shift.auto_domain

data class CarsPaginated(
    val data: List<Cars>,
    val meta: PaginationMeta
)
