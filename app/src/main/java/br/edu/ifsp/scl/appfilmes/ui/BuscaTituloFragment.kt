package br.edu.ifsp.scl.appfilmes.ui

import br.edu.ifsp.scl.appfilmes.R
import br.edu.ifsp.scl.appfilmes.api.Constantes
import br.edu.ifsp.scl.appfilmes.api.Retrofit
import br.edu.ifsp.scl.appfilmes.model.Filme
import retrofit2.Call

class BuscaTituloFragment: BuscaFragment() {

    override fun getSubtitulo() = R.string.modo_titulo
    override fun getDica() = R.string.entre_com_o_titulo_do_filme

    override fun criarChamada(parametro: String): Call<Filme> {
        return Retrofit.getFilmesApi().getPorTitulo(Constantes.APP_KEY_VALUE, parametro)
    }
}