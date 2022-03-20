package com.example.lotrquoter_enmieux.Fragments.Quotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotrquoter_enmieux.DTOs.Movie
import com.example.lotrquoter_enmieux.DTOs.Quote
import com.example.lotrquoter_enmieux.LotrAPI.LotrApi
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val selected = MutableLiveData<Quote>()
    val _movie = MutableLiveData<Movie>()
    private val lotrapi = LotrApi()

    init {
        viewModelScope.launch() { loadQuote() }
    }

    suspend fun loadQuote() {
        selected.value = lotrapi.getRandomQuote(_movie.value!!._id)
    }
}