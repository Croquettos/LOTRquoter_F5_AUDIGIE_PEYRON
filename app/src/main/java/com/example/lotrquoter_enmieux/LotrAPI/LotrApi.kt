package com.example.lotrquoter_enmieux.LotrAPI

import android.util.Log
import com.example.lotrquoter_enmieux.DTOs.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.call.*
import io.ktor.util.*
import kotlinx.coroutines.isActive
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class LotrApi {
    //classe regroupant les appels API de l'application

    suspend fun getRandomQuote(movie_id : String): Quote {
        //récupération d'une citation aléatoire d'un film choisi
        Log.e(movie_id, "GET RANDOM QUOTE")
        val client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        Log.e("client: " + client.isActive, "GET RANDOM QUOTE")
        val docsQuote: DocsQuote =
            client.get("https://the-one-api.dev/v2/movie/" + movie_id + "/quote") {
                headers { append("Authorization", "Bearer Yz6TGM2TfN4i91hIs5NS") }
            }
        Log.e("API CALL OK", "GET RANDOM QUOTE")
        client.close()
        Log.e(docsQuote.docs[Random.nextInt(docsQuote.docs.size)].dialog, "GET RANDOM QUOTE")
        return docsQuote.docs[Random.nextInt(docsQuote.docs.size)]
        //return Quote("Test", "Test", "Test", "Test")
    }

    suspend fun getMovies(): MutableList<Movie>? {
        //récupération de la liste des films
        val client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val docsMovie : DocsMovie = client.get("https://the-one-api.dev/v2/movie") {
            headers { append("Authorization", "Bearer Yz6TGM2TfN4i91hIs5NS") }
        }
        var listMovies : MutableList<Movie> = ArrayList()
        docsMovie.docs.forEach {
            listMovies!!.add(it)
        }
        listMovies.removeAt(0)
        listMovies.removeAt(0)
        listMovies.removeAt(0)
        listMovies.removeAt(0)
        listMovies.removeAt(0)
        Collections.swap(listMovies, 0, 1)
        //affichage uniquement des films de la trilogie du Seigneur des Anneaux
        client.close()
        return listMovies
    }

    suspend fun getCharacterById(character_id : String) : LOTRCharacter {
        //récupération du nom du personnage
        val client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val docsCharacter : DocsCharacter = client.get("https://the-one-api.dev/v2/character/" + character_id) {
            headers { append("Authorization", "Bearer Yz6TGM2TfN4i91hIs5NS") }
        }
        client.close()
        return docsCharacter.docs[0]
    }
}
