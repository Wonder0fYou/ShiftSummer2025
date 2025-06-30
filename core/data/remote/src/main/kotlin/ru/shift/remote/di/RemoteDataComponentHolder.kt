package ru.shift.remote.di

import ru.shift.di.BaseComponentHolder

object RemoteDataComponentHolder : BaseComponentHolder<RemoteComponentApi, RemoteDataDependencies>(){
    override fun build(dependencies: RemoteDataDependencies): RemoteComponentApi {
        return DaggerRemoteComponentApi.factory().create(dependencies)
    }
}