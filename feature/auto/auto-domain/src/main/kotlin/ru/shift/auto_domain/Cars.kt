package ru.shift.auto_domain

data class Cars(
    val id: String,
    val name: String,
    val brand: String,
    val media: List<MediaCars>,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String
)
