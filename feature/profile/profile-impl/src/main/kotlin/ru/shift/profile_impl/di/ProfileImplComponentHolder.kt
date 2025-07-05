package ru.shift.profile_impl.di

import ru.shift.di.BaseComponentHolder

object ProfileImplComponentHolder :
    BaseComponentHolder<ProfileImplComponentImpl, ProfileImplDependencies>() {
    override fun build(dependencies: ProfileImplDependencies): ProfileImplComponentImpl {
        return DaggerProfileImplComponentImpl.factory().create(dependencies)
    }
}