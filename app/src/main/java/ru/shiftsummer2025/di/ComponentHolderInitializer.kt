package ru.shiftsummer2025.di

import ru.shiftsummer2025.di.module.data.remote.RemoteDataComponentInitializer
import javax.inject.Inject

class ComponentHolderInitializer @Inject constructor(
    private val remoteDataComponentInitializer: RemoteDataComponentInitializer,
) {
    fun init() {
        initCoreData()
        initFeatures()
    }

    private fun initCoreData() {
        remoteDataComponentInitializer.init()
    }

    private fun initFeatures() {
    }
}