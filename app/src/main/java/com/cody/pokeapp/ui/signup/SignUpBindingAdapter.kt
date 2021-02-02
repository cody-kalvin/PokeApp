package com.cody.pokeapp.ui.signup

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.cody.pokeapp.api.RequestState
import com.cody.pokeapp.util.isValidEmail
import com.cody.pokeapp.util.isValidPassword
import com.google.firebase.auth.FirebaseUser

@BindingAdapter("signUpEmail", "signUpPassword")
fun Button.setSignUpEnabled(email: String?, password: String?) {
    this.isEnabled = email?.isValidEmail() == true && password?.isValidPassword() == true
}

@BindingAdapter("signUpState")
fun ProgressBar.setLoadingVisibility(state: RequestState<FirebaseUser>) {
    this.visibility = if (state == RequestState.Loading) {
        View.VISIBLE
    } else {
        View.GONE
    }
}