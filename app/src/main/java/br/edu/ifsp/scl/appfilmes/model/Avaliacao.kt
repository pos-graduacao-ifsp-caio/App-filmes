package br.edu.ifsp.scl.appfilmes.model

import com.google.gson.annotations.SerializedName

data class Avaliacao(
    @SerializedName("Source") val fonte: String,
    @SerializedName("Value") val valor: String
)