package com.cody.pokeapp.di.activity

import com.cody.pokeapp.MainActivity
import com.cody.pokeapp.di.fragment.FragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity
}