package ru.shiftsummer2025.di.module

import dagger.Module
import ru.shiftsummer2025.di.module.data.datastore.DataStoreComponentModule
import ru.shiftsummer2025.di.module.data.remote.RemoteDataModule

@Module(
    includes = [
        RemoteDataModule::class,
        DataStoreComponentModule::class,
    ]
)
class AppModule