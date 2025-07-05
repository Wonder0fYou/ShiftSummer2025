package ru.shift.auto_domain

data class PaginationMeta(
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int
)
