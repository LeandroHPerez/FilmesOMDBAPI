package br.edu.ifsp.scl.filmesomdbapi.retrofit

import br.edu.ifsp.scl.filmesomdbapi.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChamadasOmdbAPI {

    @GET("/")
    fun requestFilmByTitle(@Query("t") title: String): Call<Movie>

    @GET("/")
    fun requestFilmByID(@Query("i") id: String): Call<Movie>
}