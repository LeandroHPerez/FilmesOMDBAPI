package br.edu.ifsp.scl.filmesomdbapi.retrofit

import br.edu.ifsp.scl.filmesomdbapi.Constantes
import br.edu.ifsp.scl.filmesomdbapi.MainActivity
import br.edu.ifsp.scl.filmesomdbapi.model.Movie

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import java.lang.System.err
import android.widget.Toast


class MovieService(mainActivity: MainActivity) {

    interface ResponseOmdb{
        fun onResponse(movie: Movie)
        fun onResponseFail(error: Throwable)
    }

    // Cliente Http que conterá o interceptador de requisição para cabeçalhos dinâmicos
    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    var responseOmdb: ResponseOmdb? = null
    // Instanciando o cliente HTTP
    init {
        // Adiciona um interceptador que é um objeto de uma classe anônima
        okHttpClientBuilder.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

                // Resgatando requisição interceptada
                val reqInterceptada: Request = chain.request()
                val url = reqInterceptada.url().newBuilder().addQueryParameter(Constantes.APP_KEY_FIELD, Constantes.APP_KEY_VALUE).build()

                // Criando nova requisição a partir da interceptada e adicionando campos de cabeçalho
                val novaReq: Request = reqInterceptada.newBuilder()
                    .url(url)
                    .method(reqInterceptada.method(), reqInterceptada.body())
                    .build()
                return chain.proceed(novaReq)
            }
        })
    }

    // Novo objeto Retrofit usando a URL base e o HttpClient com interceptador
    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constantes.URL_BASE)
        .client(okHttpClientBuilder.build())
        .build()

    // Cria um objeto, a partir da Interface Retrofit, que contém as funções de requisição
    val chamadaApi: ChamadasOmdbAPI = retrofit.create(ChamadasOmdbAPI::class.java)

    fun buscarFilmeComOTitulo(titulo: String) {
        chamadaApi.requestFilmByTitle(titulo).enqueue( object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                call.cancel()
                responseOmdb?.onResponseFail(t)
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val body = response.body()
                if (body != null){
                    responseOmdb?.onResponse(body)
                }
            }
        })
    }
}










