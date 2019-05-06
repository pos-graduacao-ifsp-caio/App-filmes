package br.edu.ifsp.scl.appfilmes.api

import retrofit2.http.GET
import retrofit2.http.Query

interface FilmesApi {

    @GET
    fun getPorTituloEspecifico(@Query(Constantes.APP_KEY_VALUE) apiKey: String, @Query("t") titulo: String)

    @GET
    fun getPorTitulo(@Query(Constantes.APP_KEY_VALUE) apiKey: String, @Query("s") titulo: String)

    @GET
    fun getPorId(@Query(Constantes.APP_KEY_VALUE) apiKey: String, @Query("i") id: String)

}