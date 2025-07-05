package ru.shiftsummer2025.di.featuremodules.profile

import ru.shift.profile_data.di.ProfileDataComponentHolder
import ru.shift.profile_data.di.ProfileDependencies
import ru.shift.profile_impl.di.ProfileImplComponentHolder
import ru.shift.profile_impl.di.ProfileImplDependencies
import javax.inject.Inject
import javax.inject.Provider

class ProfileFeatureComponentInitializer @Inject constructor(
    private val profileDependencies: Provider<ProfileDependencies>,
    private val profileImplDependencies: Provider<ProfileImplDependencies>,
) {
    fun init() {
        ProfileDataComponentHolder.init(profileDependencies)
        ProfileImplComponentHolder.init(profileImplDependencies)
    }
}