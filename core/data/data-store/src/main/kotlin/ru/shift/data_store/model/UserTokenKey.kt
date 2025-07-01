package ru.shift.data_store.model

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.application.proto.UserTokensDao
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

val Context.userTokensDataStore: DataStore<UserTokensDao> by dataStore(
    fileName = "user_tokens.pb",
    serializer = UserTokensDaoSerializer
)

private object UserTokensDaoSerializer : Serializer<UserTokensDao> {

    override suspend fun readFrom(input: InputStream): UserTokensDao {
        try {
            return UserTokensDao.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UserTokensDao, output: OutputStream) = t.writeTo(output)

    override val defaultValue: UserTokensDao
        get() = UserTokensDao.getDefaultInstance()
}