package ru.shift.auto_data.mapper

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mappers.ApiSuccessModelMapper
import ru.shift.auto_domain.CarWithRents
import ru.shift.auto_domain.Cars
import ru.shift.auto_domain.CarsPaginated
import ru.shift.auto_domain.MediaCars
import ru.shift.auto_domain.PaginationMeta
import ru.shift.cars.model.CarWithRentsDto
import ru.shift.cars.model.CarsDto
import ru.shift.cars.model.MediaCarsDto
import ru.shift.cars.model.PaginationMetaDto
import ru.shift.cars.model.response.CarsPaginatedResponse
import ru.shift.remote.di.RemoteModule.Companion.BASE_URL_FOR_PICTURE
import javax.inject.Inject

class CarsMapper @Inject constructor(

) : ApiSuccessModelMapper<CarsPaginatedResponse, CarsPaginated> {
    override fun map(apiSuccessResponse: ApiResponse.Success<CarsPaginatedResponse>): CarsPaginated {
        val data = apiSuccessResponse.data
        val result = CarsPaginated(
            data = mapToCars(data.data),
            meta = mapToPaginationMeta(data.meta)
        )
        return result
    }

    fun mapToCarWithRents(carWithRentsDto: CarWithRentsDto): CarWithRents =
        CarWithRents(
            id = carWithRentsDto.id,
            name = carWithRentsDto.name,
            brand = carWithRentsDto.brand,
            bodyType = carWithRentsDto.bodyType,
            media = mapToMediaCars(carWithRentsDto.media),
            transmission = carWithRentsDto.transmission,
            price = carWithRentsDto.price,
            location = carWithRentsDto.location,
            color = carWithRentsDto.color,
            steering = carWithRentsDto.steering
        )

    private fun mapToCars(carsDto: List<CarsDto>): List<Cars> =
        carsDto.map { carsDto ->
            Cars(
                id = carsDto.id,
                name = carsDto.name,
                brand = carsDto.brand,
                media = mapToMediaCars(carsDto.media),
                transmission = carsDto.transmission,
                price = carsDto.price,
                location = carsDto.location,
                color = carsDto.color,
                bodyType = carsDto.bodyType,
                steering = carsDto.steering
            )
        }

    private fun mapToMediaCars(carsMedia: List<MediaCarsDto>): List<MediaCars> =
        carsMedia.map { mediaCarsDto ->
            MediaCars(
                url = BASE_URL_FOR_PICTURE + mediaCarsDto.url,
                isCover = mediaCarsDto.isCover,
            )
        }

    private fun mapToPaginationMeta(pagMeta: PaginationMetaDto): PaginationMeta =
        PaginationMeta(
            total = pagMeta.total,
            page = pagMeta.page,
            limit = pagMeta.limit,
            totalPages = pagMeta.totalPages,
        )
}