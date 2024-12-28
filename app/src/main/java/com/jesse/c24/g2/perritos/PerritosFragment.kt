package com.jesse.c24.g2.perritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jesse.c24.databinding.FragmentPerritosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

@AndroidEntryPoint
class PerritosFragment : Fragment() {
    private var _binding: FragmentPerritosBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: DogsAdapter
    private var myDogs = mutableListOf<String>("ddd", "aaa", "aaaa")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerritosBinding.inflate(layoutInflater, container, false)
        initRV()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDogsByBreed("hound")
    }

    private fun initRV() {
        adapter = DogsAdapter(myDogs)
        binding.rvDogs.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDogs.adapter = adapter
    }

    private fun getDogsByBreed(breed: String) {
        val retrofit = getRetrofit()
        lifecycleScope.launch {
            val call = retrofit.create(PuppiesApi::class.java).getRandomDogs("$breed/images")

            if (call.isSuccessful) {
                var puppies = call.body()?.message ?: emptyList()
                myDogs.clear()
                myDogs.addAll(puppies)
                adapter.notifyDataSetChanged()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

interface PuppiesApi {
    @GET
    suspend fun getRandomDogs(@Url url: String): Response<DogsResponse>
}


fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breed/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}