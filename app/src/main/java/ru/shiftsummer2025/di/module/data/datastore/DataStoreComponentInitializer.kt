package ru.shiftsummer2025.di.module.data.datastore

import ru.shift.data_store.di.DataStoreComponentHolder
import ru.shift.data_store.di.DataStoreDependencies
import javax.inject.Inject
import javax.inject.Provider

class DataStoreComponentInitializer @Inject constructor(
    private val dataStoreDependencies: Provider<DataStoreDependencies>,
) {
    fun init() {
        DataStoreComponentHolder.init(dataStoreDependencies)
    }
}