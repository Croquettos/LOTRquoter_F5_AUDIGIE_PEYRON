package com.example.lotrquoter_enmieux.Fragments.Quotes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotrquoter_enmieux.DTOs.Quote
import com.example.lotrquoter_enmieux.LotrAPI.LotrApi
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val selected = MutableLiveData<Quote>()
    var movie_id = MutableLiveData<String>()
    private val lotrapi = LotrApi()

    fun updateData() {
        viewModelScope.launch { loadQuote(movie_id.value) }
    }

    suspend fun loadQuote(movie_id : String?) {
        selected.value = lotrapi.getRandomQuote(movie_id)
        Log.e(selected.value.toString(), "LOAD QUOTE")
    }

}