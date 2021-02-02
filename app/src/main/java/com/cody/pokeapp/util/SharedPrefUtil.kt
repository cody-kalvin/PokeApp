package com.cody.pokeapp.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefUtil @Inject constructor(@ApplicationContext val context: Context) {
    private val instance = context.getSharedPreferences(USER_CREDENTIALS, Context.MODE_PRIVATE)

    private val editor = instance.edit()

    var tokenId: String = ""
        set(value) {
            field = value
            editor.putString(USER_TOKEN_ID, value)
            editor.apply()
        }
        get() {
            return instance.getString(USER_TOKEN_ID, "") ?: ""
        }

    companion object {
        const val USER_CREDENTIALS = "user_credentials"
        const val USER_TOKEN_ID = "user_token_id"
    }
}