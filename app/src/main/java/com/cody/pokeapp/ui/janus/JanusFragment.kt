package com.cody.pokeapp.ui.janus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.cody.pokeapp.R
import com.cody.pokeapp.api.RequestState
import com.cody.pokeapp.databinding.FragmentJanusBinding
import com.cody.pokeapp.di.common.Injectable
import com.cody.pokeapp.util.autoCleared
import javax.inject.Inject

class JanusFragment : Fragment(), Injectable {
    private var binding: FragmentJanusBinding by autoCleared()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: JanusViewModel by viewModels {
        viewModelFactory
    }

    private val navController by lazy {
        (requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJanusBinding.inflate(inflater, container, false)
        setupBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupObservers()
        checkToken()
    }

    private fun setupBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setupObservers() {
        viewModel.tokenState.observe(viewLifecycleOwner) {
            val state = it ?: return@observe
            if (state is RequestState.Failure) {
                navController.navigate(R.id.loginFragment)
            } else if (state is RequestState.Success) {
                navController.navigate(R.id.deckFragment)
            }
        }
    }

    private fun checkToken() {
        viewModel.checkToken()
    }
}