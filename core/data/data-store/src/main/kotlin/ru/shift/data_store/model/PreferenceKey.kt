package ru.shift.data_store.model

sealed interface PreferenceKey {
    data object UserToken : PreferenceKey
}