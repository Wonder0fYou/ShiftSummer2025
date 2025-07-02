package ru.shiftsummer2025.di.module.data.datastore

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.shift.data_store.api.BaseDataStoreApi
import ru.shift.data_store.di.DataStoreComponentHolder
import ru.shift.data_store.di.DataStoreDependencies

@Module
class DataStoreComponentModule {

    @Provides
    fun provideDataStoreDependencies(
        context: Application
    ): DataStoreDependencies = object : DataStoreDependencies {
        override val context: Context = context
    }

    @Provides
    fun provideBaseDataStoreApi(): BaseDataStoreApi =
        DataStoreComponentHolder.get().baseDataStoreApi()
}