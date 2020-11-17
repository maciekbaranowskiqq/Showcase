package com.showcase.ui.brewery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.showcase.common.observeNotNull
import com.showcase.showcase.databinding.BreweryFragmentBinding
import com.showcase.ui.brewery.BreweryScreenInteractions.ContinueButtonClicked
import com.showcase.ui.brewery.BreweryScreenInteractions.ScreenEntered
import com.showcase.ui.brewery.BreweryScreenViewModel.BreweryScreenViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreweryScreenFragment : Fragment() {
    private lateinit var binding: BreweryFragmentBinding
    private val viewModel: BreweryScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BreweryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initRendering()
        initInteractions()
    }

    private fun initInteractions() {
        binding.continueButton.setOnClickListener { viewModel.onInteraction(ContinueButtonClicked) }
    }

    private fun initRendering() = with(viewModel) {
        isProgressIndicatorVisibleLiveData.observeNotNull(viewLifecycleOwner, ::renderProgressIndicator)
        breweryScreenViewStateLiveData.observeNotNull(viewLifecycleOwner, ::renderWinnerNameText)
    }

    private fun renderProgressIndicator(isVisible: Boolean) = with(binding) {
        progress.isVisible = isVisible
    }

    private fun renderWinnerNameText(viewState: BreweryScreenViewState) = with(binding) {
        textBreweryName.text = viewState.breweryName
    }

    override fun onResume() {
        super.onResume()

        viewModel.onInteraction(ScreenEntered)
    }
}