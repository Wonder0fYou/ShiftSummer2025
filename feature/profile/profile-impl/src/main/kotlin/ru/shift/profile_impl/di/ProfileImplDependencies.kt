package ru.shift.profile_impl.di

import ru.shift.di.BaseDependenciesApi
import ru.shift.profile_api.repository.ProfileRepository

interface ProfileImplDependencies : BaseDependenciesApi {
    val profileRepository: ProfileRepository
}