package br.edu.ifsp.scl.appfilmes.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.appfilmes.R
import br.edu.ifsp.scl.appfilmes.model.Filme
import kotlinx.android.synthetic.main.fragment_busca.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.longToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BuscaFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        activity?.toolbar?.setSubtitle(this.getSubtitulo())
        return inflater.inflate(R.layout.fragment_busca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etParametro.setHint(this.getDica())
        btBuscar.setOnClickListener { this.buscarFilme() }
    }

    private fun buscarFilme() {
        val dialog = ProgressDialog(context)
        dialog.setMessage(getString(R.string.por_favor_aguarde))
        dialog.show()
        this.criarChamada(etParametro.text.toString()).enqueue(object:
            Callback<Filme> {
            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                dialog.dismiss()
                val filme = response.body()
                if (filme?.isErro() != false) {
                    mostrarErro(filme?.erro)
                } else {
                    startActivity(DetalhesActivity.getCallingIntent(context, filme))
                }
            }

            override fun onFailure(call: Call<Filme>, t: Throwable) {
                dialog.dismiss()
                mostrarErro(t.message)
            }
        })
    }

    private fun mostrarErro(mensagem: String?) {
        longToast(getString(R.string.erro_ao_buscar_filme, mensagem ?: getString(R.string.erro_desconhecido))).show()
    }

    protected abstract fun getSubtitulo(): Int
    protected abstract fun getDica(): Int
    protected abstract fun criarChamada(parametro: String): Call<Filme>

}