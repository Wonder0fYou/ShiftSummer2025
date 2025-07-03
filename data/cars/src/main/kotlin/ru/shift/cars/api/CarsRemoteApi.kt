package ru.shift.cars.api

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import ru.shift.cars.model.request.RentCarRequest
import ru.shift.cars.model.response.BaseResponse
import ru.shift.cars.model.response.CarRentIdResponse
import ru.shift.cars.model.response.CarRentResponse
import ru.shift.cars.model.response.CarRentsResponse
import ru.shift.cars.model.response.CarResponse
import ru.shift.cars.model.response.CarsPaginatedResponse
import ru.shift.remote.api.BaseRemoteApi

interface CarsRemoteApi : BaseRemoteApi {

    @GET("${API_CARS}/info")
    suspend fun getAllCars(
        @Query("search") search: String? = null,
        @Query("maxPrice") maxPrice: Int? = null,
        @Query("minPrice") minPrice: Int? = null,
        @Query("transmission") transmission: String? = null,
        @Query("bodyType") bodyType: String? = null,
        @Query("brand") brand: String? = null,
        @Query("color") color: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("page") page: Int? = null
    ): ApiResponse<CarsPaginatedResponse>

    @GET("$API_CARS/info/{carId}")
    suspend fun getCar(
        @Path("carId") carId: Int
    ): ApiResponse<CarResponse>

    @POST("${API_CARS}/rent")
    suspend fun postRentCar(
        @Body rentCarRequest: RentCarRequest
    ): ApiResponse<CarRentResponse>

    @GET("${API_CARS}/rent")
    suspend fun getRentsCars(): ApiResponse<CarRentsResponse>

    @GET("$API_CARS/rent/{carRentId}")
    suspend fun getRentCar(
        @Path("carRentId") carRentId: String
    ): ApiResponse<CarRentIdResponse>

    @PUT("${API_CARS}/rent/cancel")
    suspend fun putRentCancel(
        @Body carRentId: String
    ): ApiResponse<BaseResponse>

    companion object {
        private const val API_CARS = "/api/cars"
    }
}