package ru.shift.auto_api.repository

import kotlinx.coroutines.flow.Flow
import ru.shift.auto_domain.CarWithRents
import ru.shift.auto_domain.CarsPaginated
import ru.shiftsummer2025.feature_api.result.ReasonError
import ru.shiftsummer2025.feature_api.result.Result

interface AutoRepository {
    suspend fun getAllCars(): Flow<Result<CarsPaginated, ReasonError>>
    suspend fun getCarById(carId: String): Flow<Result<CarWithRents, ReasonError>>
}