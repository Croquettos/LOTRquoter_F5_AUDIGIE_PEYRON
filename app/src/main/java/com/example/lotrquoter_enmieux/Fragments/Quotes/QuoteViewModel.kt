package com.example.lotrquoter_enmieux.Fragments.Quotes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotrquoter_enmieux.DTOs.LOTRCharacter
import com.example.lotrquoter_enmieux.DTOs.Quote
import com.example.lotrquoter_enmieux.LotrAPI.LotrApi
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val selected = MutableLiveData<Quote>()
    val movie_id = MutableLiveData<String>()
    val character = MutableLiveData<LOTRCharacter>()
    private val lotrapi = LotrApi()

    fun updateData() {
        viewModelScope.launch {
            loadQuote(movie_id.value!!)
            loadCharacter(selected.value!!.character)
        }
    }

    suspend fun loadQuote(movie_id : String) {
        //appel API pour la citation
        Log.e(movie_id, "LOAD QUOTE")
        selected.value = lotrapi.getRandomQuote(movie_id)
        //selected.value = Quote("Test", "Test", "Test", "Test")
        Log.e(selected.value.toString(), "LOAD QUOTE")
    }

    suspend fun loadCharacter(character_id : String) {
        //appel API pour le personnage
        Log.e(character_id, "LOAD CHARACTER")
        character.value = lotrapi.getCharacterById(character_id)
        Log.e(character.value!!.name, "LOAD CHARACTER")
    }

}