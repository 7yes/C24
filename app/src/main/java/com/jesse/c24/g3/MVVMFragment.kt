package com.jesse.c24.g3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jesse.c24.databinding.FragmentMVVMBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MVVMFragment : Fragment() {
    private var _binding: FragmentMVVMBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMVVMBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}