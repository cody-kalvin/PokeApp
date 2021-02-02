package com.cody.pokeapp.ui.janus

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.cody.pokeapp.api.RequestState

@BindingAdapter("tokenState")
fun ProgressBar.setLoadingVisibility(state: RequestState<String>) {
    this.visibility = if (state == RequestState.Loading) {
        View.VISIBLE
    } else {
        View.GONE
    }
}