package com.example.lotrquoter_enmieux.DTOs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class  Character(val _id : String, val name : String)

@Serializable
data class DocsCharacter(val docs : List<Character>)

@Serializable
data class Movie(val _id : String, val name : String)

@Serializable
data class DocsMovie(val docs : List<Movie>)

@Serializable
data class Quote(val _id : String, val dialog : String, val movie : String, val character : String)

@Serializable
data class DocsQuote(val docs : List<Quote>)