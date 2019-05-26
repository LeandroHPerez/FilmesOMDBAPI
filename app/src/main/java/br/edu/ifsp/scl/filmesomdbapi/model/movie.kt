package br.edu.ifsp.scl.filmesomdbapi.model

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("Source")
    var source: String = "",
    @SerializedName("Value")
    var value: String = ""
)

data class Movie (
    @SerializedName("Title")
    var title: String = "",
    @SerializedName("Year")
    var year: String = "",
    @SerializedName("Released")
    var released: String = "",
    @SerializedName("Genre")
    var genre: String = "",
    @SerializedName("Director")
    var director: String = "",
    @SerializedName("Poster")
    var poster: String = "",
    @SerializedName("Actors")
    var actors: String = "",
    @SerializedName("Language")
    var language: String = "",
    @SerializedName("Country")
    var country: String = "",
    @SerializedName("Ratings")
    var ratings: List<Rating> = listOf(),
    @SerializedName("imdbRating")
    var imdbRating: String = "",
    @SerializedName("Type")
    var typeMovie: String = "",
    @SerializedName("Production")
    var production: String = "",
    @SerializedName("Website")
    var website: String = ""
)