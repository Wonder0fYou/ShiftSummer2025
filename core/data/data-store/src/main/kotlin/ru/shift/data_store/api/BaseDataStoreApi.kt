package ru.shift.data_store.api

import kotlinx.coroutines.flow.Flow
import ru.shift.data_store.model.PreferenceKey

interface BaseDataStoreApi {

    suspend fun <T> save(preferenceKey: PreferenceKey, value: () -> T)

    fun <T> read(preferenceKey: PreferenceKey): Flow<T>

    suspend fun clear(preferenceKey: PreferenceKey)
}