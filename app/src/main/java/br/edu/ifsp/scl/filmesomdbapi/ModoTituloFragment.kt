package br.edu.ifsp.scl.filmesomdbapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.appfilmes.ModoFilmeFragment
import kotlinx.android.synthetic.main.toolbar.*

class ModoTituloFragment: ModoFilmeFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layoutFragment = inflater.inflate(R.layout.fragment_modo_titulo, null)

        activity?.toolbar?.subtitle = "Modo título"

        return layoutFragment
    }

    override fun buscarFilme(view: View) {

    }
}