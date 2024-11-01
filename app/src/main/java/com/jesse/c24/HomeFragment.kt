package com.jesse.c24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jesse.c24.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.btnLyoFrame.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_lyoFrameFragment) }
        binding.btnLyoLinear.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_ltoLinearFragment) }
        binding.btnLyoConstraint.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_lyoConstrainFragment) }
        binding.btnDayPicker.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_dayPickerFragment) }
        binding.btnTimePicker.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_timePickerFragment) }
        binding.btnPerritos.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_perritosFragment) }
        binding.btnMvvm.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_MVVMFragment) }
        binding.btnChips.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_chipsFragment) }
        binding.btnRv.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_rvFragment) }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
