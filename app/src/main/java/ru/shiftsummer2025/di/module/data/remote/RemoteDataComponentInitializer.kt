package ru.shiftsummer2025.di.module.data.remote

import ru.shift.remote.di.RemoteDataComponentHolder
import ru.shift.remote.di.RemoteDataDependencies
import javax.inject.Inject
import javax.inject.Provider

class RemoteDataComponentInitializer @Inject constructor(
    private val remoteDataDependencies: Provider<RemoteDataDependencies>
) {
    fun init() {
        RemoteDataComponentHolder.init(remoteDataDependencies)
    }
}