package skeleton.example.aliak.skeleton.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import skeleton.example.aliak.skeleton.databinding.FragmentMainBinding
import skeleton.example.aliak.skeleton.presentation.base.BaseViewModelFragment


class MainFragment : BaseViewModelFragment() {
    companion object {
        const val TAG = "MainFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        val tabsViewModel = MainViewModel()
        this.viewModel = tabsViewModel
        binding.viewModel = tabsViewModel
        return binding.root
    }
}