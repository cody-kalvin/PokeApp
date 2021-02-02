package com.cody.pokeapp.util

fun String.isValidEmail() = android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword() = this.length in 8..16