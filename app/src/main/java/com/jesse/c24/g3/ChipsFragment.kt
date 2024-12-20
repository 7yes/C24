package com.jesse.c24.g3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jesse.c24.databinding.FragmentChipsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChipsFragment : Fragment() {
    private var _binding: FragmentChipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChipsBinding.inflate(layoutInflater, container, false)
        binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            // Respond to change in selection
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}