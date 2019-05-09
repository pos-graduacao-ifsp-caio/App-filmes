package br.edu.ifsp.scl.appfilmes.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private var mFilmesApi: FilmesApi? = null

    fun getFilmesApi(): FilmesApi {
        if (mFilmesApi == null) {
            mFilmesApi = Retrofit.Builder()
                .baseUrl(Constantes.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FilmesApi::class.java)
        }
        return mFilmesApi!!
    }
}