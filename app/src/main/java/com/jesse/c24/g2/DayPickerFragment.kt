package com.jesse.c24.g2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jesse.c24.databinding.FragmentDayPickerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DayPickerFragment : Fragment() {
    private var _binding: FragmentDayPickerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayPickerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}