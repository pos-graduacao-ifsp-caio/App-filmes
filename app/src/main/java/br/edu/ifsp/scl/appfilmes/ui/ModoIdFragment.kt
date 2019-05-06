package br.edu.ifsp.scl.appfilmes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.appfilmes.R
import kotlinx.android.synthetic.main.toolbar.*

class ModoIdFragment: ModoFilmeFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layoutFragment = inflater.inflate(R.layout.fragment_modo_id, null)

        activity?.toolbar?.subtitle = "Modo id"

        return layoutFragment
    }

    override fun buscarFilme(view: View) {

    }

}
