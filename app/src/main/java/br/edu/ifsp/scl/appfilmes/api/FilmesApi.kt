package br.edu.ifsp.scl.appfilmes.api

import br.edu.ifsp.scl.appfilmes.model.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmesApi {

    @GET("/")
    fun getPorTitulo(@Query(Constantes.APP_KEY_FIELD) apiKey: String, @Query("t") titulo: String): Call<Filme>

    @GET("/")
    fun getPorId(@Query(Constantes.APP_KEY_FIELD) apiKey: String, @Query("i") id: String): Call<Filme>

}