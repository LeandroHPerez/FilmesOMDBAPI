package br.edu.ifsp.scl.filmesomdbapi.model

import com.google.gson.annotations.SerializedName

data class Movie(
//    var title: String = "",
//    var year: String = "",
//    var released: String = "",
//    var genre: String = "",
//    var director: String = "",
//    var poster: String = "",
//    var website: String = ""

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
    @SerializedName("Website")
    var website: String = ""
)