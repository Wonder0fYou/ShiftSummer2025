package ru.shiftsummer2025.di

import ru.shiftsummer2025.di.featuremodules.authorization.AuthorizationFeatureComponentInitializer
import ru.shiftsummer2025.di.module.data.datastore.DataStoreComponentInitializer
import ru.shiftsummer2025.di.module.data.remote.RemoteDataComponentInitializer
import javax.inject.Inject

class ComponentHolderInitializer @Inject constructor(
    private val remoteDataComponentInitializer: RemoteDataComponentInitializer,
    private val authorizationFeatureComponentInitializer: AuthorizationFeatureComponentInitializer,
    private val dataStoreComponentInitializer: DataStoreComponentInitializer,
) {
    fun init() {
        initCoreData()
        initFeatures()
    }

    private fun initCoreData() {
        remoteDataComponentInitializer.init()
        dataStoreComponentInitializer.init()
    }

    private fun initFeatures() {
        authorizationFeatureComponentInitializer.init()
    }
}