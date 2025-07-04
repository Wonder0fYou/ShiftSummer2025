package ru.shift.auto_data.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.shift.auto_api.repository.AutoRepository
import ru.shift.auto_data.mapper.CarsMapper
import ru.shift.auto_domain.CarsPaginated
import ru.shift.cars.api.CarsRemoteApi
import ru.shiftsummer2025.feature_api.result.ReasonError
import ru.shiftsummer2025.feature_api.result.Result
import javax.inject.Inject

class AutoRepositoryImpl @Inject constructor(
    private val carsRemoteApi: CarsRemoteApi,
    private val carsMapper: CarsMapper
) : AutoRepository{
    override suspend fun getAllCars(): Flow<Result<CarsPaginated, ReasonError>> = flow {
        val response = carsRemoteApi.getAllCars()
        response.suspendOnSuccess {
            if (data.success) {
                val allCars = carsMapper.map(this)
                emit(Result.Success(allCars))
            } else {
                val error = ReasonError(reason = data.reason)
                emit(Result.Error(error))
            }
        }.suspendOnError {

        }
    }
}