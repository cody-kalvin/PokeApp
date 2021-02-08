package com.cody.pokeapp.ui.deck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.cody.pokeapp.R
import com.cody.pokeapp.databinding.FragmentDeckBinding
import com.cody.pokeapp.di.common.Injectable
import com.cody.pokeapp.util.autoCleared

class DeckFragment : Fragment(), Injectable {
    private var binding: FragmentDeckBinding by autoCleared()

    private val navController by lazy {
        (requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupInteractions()
    }

    private fun setupInteractions() {
        binding.actionGoToProfile.setOnClickListener {
            navController.navigate(DeckFragmentDirections.goToProfile())
        }
    }
}