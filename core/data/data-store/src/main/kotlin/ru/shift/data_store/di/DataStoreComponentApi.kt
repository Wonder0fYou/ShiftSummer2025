package ru.shift.data_store.di

import dagger.Component
import ru.shift.data_store.api.BaseDataStoreApi
import ru.shift.di.BaseComponentApi

@Component(
    modules = [DataStoreModule::class],
    dependencies = [DataStoreDependencies::class]
)
interface DataStoreComponentApi : BaseComponentApi {

    fun baseDataStoreApi(): BaseDataStoreApi

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: DataStoreDependencies,
        ): DataStoreComponentApi
    }
}