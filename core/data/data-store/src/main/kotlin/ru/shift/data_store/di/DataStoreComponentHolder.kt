package ru.shift.data_store.di

import ru.shift.di.BaseComponentHolder

object DataStoreComponentHolder :
    BaseComponentHolder<DataStoreComponentApi, DataStoreDependencies>() {
    override fun build(dependencies: DataStoreDependencies): DataStoreComponentApi {
        return DaggerDataStoreComponentApi.factory().create(dependencies)
    }
}