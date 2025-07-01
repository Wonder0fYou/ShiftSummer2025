package ru.shiftsummer2025.data.remote

import com.example.application.proto.UserTokensDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.shift.data_store.api.BaseDataStoreApi
import ru.shift.data_store.model.PreferenceKey
import ru.shift.remote.api.TokenProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenProviderImpl @Inject constructor(
    private val baseDataStoreApi: BaseDataStoreApi,
) : TokenProvider {

    @Volatile
    private var userToken: UserTokensDao = UserTokensDao.getDefaultInstance()

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    init {
        coroutineScope.launch {
            baseDataStoreApi.read<UserTokensDao>(PreferenceKey.UserToken).collect { token ->
                userToken = token
            }
        }
    }

    override fun getToken(): String {
        return userToken.token
    }
}