package com.cody.pokeapp.di.application

import android.app.Application
import com.cody.pokeapp.di.viewmodel.ViewModelModule
import com.cody.pokeapp.util.SharedPrefUtil
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {
    @Singleton
    @Provides
    fun provideFirebaseAuth() = Firebase.auth

    @Singleton
    @Provides
    fun provideSharedPrefUtil(application: Application) = SharedPrefUtil(application)
}