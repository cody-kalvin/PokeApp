package com.cody.pokeapp.di.fragment

import com.cody.pokeapp.ui.deck.DeckFragment
import com.cody.pokeapp.ui.janus.JanusFragment
import com.cody.pokeapp.ui.login.LoginFragment
import com.cody.pokeapp.ui.profile.ProfileFragment
import com.cody.pokeapp.ui.signup.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeJanusFragment(): JanusFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeSignUpFragment(): SignUpFragment

    @ContributesAndroidInjector
    abstract fun contributeDeckFragment(): DeckFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}