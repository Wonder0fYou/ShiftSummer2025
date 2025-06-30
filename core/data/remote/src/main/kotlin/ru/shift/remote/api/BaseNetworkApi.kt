package ru.shift.remote.api

interface BaseNetworkApi {
    fun getRemoteApi(clazz: Class<out BaseRemoteApi>): BaseRemoteApi
}