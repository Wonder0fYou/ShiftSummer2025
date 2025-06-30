package ru.shift.remote.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.shift.remote.api.BaseNetworkApi
import ru.shift.remote.api.BaseRemoteApi
import ru.shift.remote.di.RemoteModule.Companion.BASE_URL
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
    ): OkHttpClient = OkHttpClient.Builder()
        .build()


    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .create()


    @Provides
    @Singleton
    fun provideBaseRemoteApi(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
        .build()


    @Provides
    fun provideBaseNetworkApi(retrofit: Retrofit): BaseNetworkApi = object : BaseNetworkApi {
        override fun getRemoteApi(clazz: Class<out BaseRemoteApi>): BaseRemoteApi {
            return retrofit.create(clazz)
        }
    }

    companion object {
        private const val BASE_URL = "https://shift-intensive.ru/"
    }
}