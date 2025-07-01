package ru.shiftsummer2025.di

import ru.shiftsummer2025.di.featuremodules.authorization.AuthorizationFeatureComponentInitializer
import ru.shiftsummer2025.di.module.data.remote.RemoteDataComponentInitializer
import javax.inject.Inject

class ComponentHolderInitializer @Inject constructor(
    private val remoteDataComponentInitializer: RemoteDataComponentInitializer,
    private val authorizationFeatureComponentInitializer: AuthorizationFeatureComponentInitializer
) {
    fun init() {
        initCoreData()
        initFeatures()
    }

    private fun initCoreData() {
        remoteDataComponentInitializer.init()
    }

    private fun initFeatures() {
        authorizationFeatureComponentInitializer.init()
    }
}