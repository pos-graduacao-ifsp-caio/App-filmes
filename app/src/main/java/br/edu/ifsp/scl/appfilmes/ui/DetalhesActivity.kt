package br.edu.ifsp.scl.appfilmes.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.edu.ifsp.scl.appfilmes.R
import br.edu.ifsp.scl.appfilmes.model.Filme
import kotlinx.android.synthetic.main.activity_detalhes.*
import kotlinx.android.synthetic.main.toolbar.*

class DetalhesActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_FILME = "DetalhesActivity.Filme"

        fun getCallingIntent(context: Context?, filme: Filme): Intent {
            return Intent(context, DetalhesActivity::class.java)
                .putExtra(EXTRA_FILME, filme)
        }
    }

    private var mFilme: Filme? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.detalhes)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mFilme = intent.getSerializableExtra(EXTRA_FILME) as Filme
        this.preencherCampos()
    }

    private fun preencherCampos() {
        tvTitulo.text = mFilme?.titulo
        tvAno.text = mFilme?.ano
        tvDataLancamento.text = mFilme?.dataLancamento
        tvDiretor.text = mFilme?.diretor
        tvAtores.text = mFilme?.atores
        tvIdioma.text = mFilme?.idioma
        tvPais.text = mFilme?.pais
        tvNotaAvaliacao.text = mFilme?.notasAvaliacao?.joinToString("\n") { "${it.fonte}: ${it.valor}" }
        tvNotaImbd.text = mFilme?.notaImdb
        tvTipo.text = mFilme?.tipo
        tvProdutora.text = mFilme?.produtora
    }
}