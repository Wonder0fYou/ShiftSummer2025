package ru.shift.cars.model

data class CarsDto(
    val id: String,
    val name: String,
    val brand: String,
    val media: List<MediaCarsDto>,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String
)
