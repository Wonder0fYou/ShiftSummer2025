package ru.shift.data_store.di

import android.content.Context
import ru.shift.di.BaseDependenciesApi

interface DataStoreDependencies : BaseDependenciesApi {
    val context: Context
}