package ru.shift.data_store.di

import dagger.Binds
import dagger.Module
import ru.shift.data_store.DataStoreManager
import ru.shift.data_store.api.BaseDataStoreApi

@Module
interface DataStoreModule {

    @Binds
    fun bindBaseDataStoreApi(impl: DataStoreManager): BaseDataStoreApi
}