package com.jesse.c24.g3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jesse.c24.databinding.FragmentRvBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RvFragment : Fragment() {
    private var _binding: FragmentRvBinding? = null
    private val binding get() = _binding!!

    val gameList = listOf<GameModel>(GameModel("Mario", 312, "error con data"),
        GameModel("Contra", 1322, "error con licencia"),
        GameModel("PacMan", 42, "")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

//sealed Class

data class GameModel(val title: String, val serialNumber: Int, val error: String)