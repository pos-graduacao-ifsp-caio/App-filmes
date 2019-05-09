package br.edu.ifsp.scl.appfilmes.model

import com.google.gson.annotations.SerializedName

abstract class Response {

    @SerializedName("Error") val erro: String? = null

    fun isErro(): Boolean {
        return this.erro?.isNotEmpty() ?: false
    }
}