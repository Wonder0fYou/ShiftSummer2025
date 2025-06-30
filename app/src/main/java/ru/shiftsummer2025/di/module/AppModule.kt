package ru.shiftsummer2025.di.module

import dagger.Module
import ru.shiftsummer2025.di.module.data.remote.RemoteDataModule

@Module(
    includes = [
        RemoteDataModule::class,
    ]
)
class AppModule