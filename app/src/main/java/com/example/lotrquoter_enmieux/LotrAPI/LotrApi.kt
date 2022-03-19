package com.example.lotrquoter_enmieux.LotrAPI

import android.util.Log
import com.example.lotrquoter_enmieux.DTOs.DocsMovie
import com.example.lotrquoter_enmieux.DTOs.DocsQuote
import com.example.lotrquoter_enmieux.DTOs.Movie
import com.example.lotrquoter_enmieux.DTOs.Quote
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.call.*
import io.ktor.util.*
import kotlin.random.Random

class LotrApi {
    suspend fun getRandomQuote(movie : String, character : String): Quote {
        val client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            defaultRequest {
                header("Authorization", "Bearer " + "ib4MK83OGO3dknYqM2P8")
            }
        }
        val docsQuotes : DocsQuote = client.get("https://the-one-api.dev/v2/character/" + character + "/quote")
        client.close()

        return docsQuotes.docs[Random.nextInt(docsQuotes.docs.size)]
        
    }

    suspend fun getMovies(): MutableList<Movie>? {
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
            headers { append("Authorization", "Bearer ib4MK83OGO3dknYqM2P8") }
        }
        val listMovies : MutableList<Movie>? = null
        docsMovie.docs.forEach {
            listMovies?.add(it)
            Log.e(it.name, "GET MOVIES")
        }
        client.close()
        return listMovies
    }
    suspend fun getCharactersFromMovie(movie : String) {

    }
}
