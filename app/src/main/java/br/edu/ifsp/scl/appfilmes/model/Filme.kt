package br.edu.ifsp.scl.appfilmes.model

import com.google.gson.annotations.SerializedName

data class Filme(
    @SerializedName("Title") val titulo: String,
    @SerializedName("Year") val ano: String,
    @SerializedName("Released") val dataLancamento: String,
    @SerializedName("Director") val diretor: String,
    @SerializedName("Actors") val atores: String,
    @SerializedName("Language") val idioma: String,
    @SerializedName("Country") val pais: String,
    @SerializedName("Ratings") val notasAvaliacao: List<Avaliacao>,
    @SerializedName("imdbRating") val notaImdb: String,
    @SerializedName("Type") val tipo: String,
    @SerializedName("Production") val produtora: String,
    @SerializedName("Website") val website: String
) : Response()