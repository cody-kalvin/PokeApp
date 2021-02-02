package com.cody.pokeapp.ui.janus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cody.pokeapp.api.RequestState
import com.cody.pokeapp.util.SharedPrefUtil
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JanusViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val sharedPref: SharedPrefUtil
) : ViewModel() {
    private val _tokenState: MutableLiveData<RequestState<String>> =
        MutableLiveData(RequestState.Initial)
    val tokenState: LiveData<RequestState<String>> = _tokenState

    fun checkToken() {
        _tokenState.value = RequestState.Loading

        val user = auth.currentUser
        if (user == null) {
            _tokenState.value = RequestState.Failure("No logged in user")
        } else {
            user.getIdToken(true)
                .addOnCompleteListener { task ->
                    val token = task.result?.token
                    if (task.isSuccessful && !token.isNullOrBlank()) {
                        sharedPref.tokenId = token
                        _tokenState.value = RequestState.Success(token)
                    } else {
                        _tokenState.value =
                            RequestState.Failure(task.exception?.message ?: "Unknown error")
                    }
                }
        }
    }
}