package com.example.lotrquoter_enmieux.Fragments.Movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotrquoter_enmieux.DTOs.Movie
import com.example.lotrquoter_enmieux.LotrAPI.LotrApi
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var selected = MutableLiveData<MutableList<Movie>>()
    private val lotrapi = LotrApi()

    init {
        selected.value = mutableListOf()
        viewModelScope.launch() { loadMovies() }
    }

    suspend fun loadMovies() {
        selected.value = lotrapi.getMovies()
    }
}