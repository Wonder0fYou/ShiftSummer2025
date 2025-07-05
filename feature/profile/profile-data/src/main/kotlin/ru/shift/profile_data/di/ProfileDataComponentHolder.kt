package ru.shift.profile_data.di

import ru.shift.di.BaseComponentHolder

object ProfileDataComponentHolder : BaseComponentHolder<ProfileDataComponent, ProfileDependencies>() {
    override fun build(dependencies: ProfileDependencies): ProfileDataComponent {
        return DaggerProfileDataComponent.factory().create(dependencies)
    }
}