package ru.shift.auto_impl.di

import ru.shift.auto_api.repository.AutoRepository
import ru.shift.di.BaseDependenciesApi

interface AutoImplDependencies : BaseDependenciesApi {
    val autoRepository: AutoRepository
}