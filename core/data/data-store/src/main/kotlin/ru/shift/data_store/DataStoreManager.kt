package ru.shift.data_store

import android.content.Context
import com.example.application.proto.UserTokensDao
import kotlinx.coroutines.flow.Flow
import ru.shift.data_store.api.BaseDataStoreApi
import ru.shift.data_store.model.PreferenceKey
import ru.shift.data_store.model.userTokensDataStore
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    private val context: Context
) : BaseDataStoreApi {
    override suspend fun <T> save(preferenceKey: PreferenceKey, value: () -> T) {
        when (preferenceKey) {
            PreferenceKey.UserToken -> context.userTokensDataStore.updateData {
                value.invoke() as UserTokensDao
            }
        }
    }

    override fun <T> read(preferenceKey: PreferenceKey): Flow<T> {
        val data = when (preferenceKey) {
            PreferenceKey.UserToken -> context.userTokensDataStore.data
        }
        return data as Flow<T>
    }

    override suspend fun clear(preferenceKey: PreferenceKey) {
        when (preferenceKey) {
            PreferenceKey.UserToken -> context.userTokensDataStore.updateData {
                it.toBuilder().clear().build()
            }
        }
    }
}