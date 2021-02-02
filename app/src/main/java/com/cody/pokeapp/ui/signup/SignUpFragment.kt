package com.cody.pokeapp.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.cody.pokeapp.R
import com.cody.pokeapp.api.RequestState
import com.cody.pokeapp.databinding.FragmentSignUpBinding
import com.cody.pokeapp.util.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private var binding: FragmentSignUpBinding by autoCleared()

    private val viewModel: SignUpViewModel by viewModels()

    private val navController by lazy {
        (requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        setupBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupObservers()
        setupInteractions()
    }

    private fun setupBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setupObservers() {
        viewModel.signUpState.observe(viewLifecycleOwner) {
            val state = it ?: return@observe
            if (state is RequestState.Failure) {
                Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()
            } else if (state is RequestState.Success) {
                navController.navigate(R.id.deckFragment)
            }
        }
    }

    private fun setupInteractions() {
        binding.actionSignUp.setOnClickListener {
            viewModel.signUp()
        }

        binding.actionLogin.setOnClickListener {
            navController.navigate(R.id.loginFragment)
        }
    }
}