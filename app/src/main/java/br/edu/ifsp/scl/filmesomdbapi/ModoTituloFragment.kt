package br.edu.ifsp.scl.filmesomdbapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import br.edu.ifsp.scl.appfilmes.ModoFilmeFragment
import kotlinx.android.synthetic.main.toolbar.*

class ModoTituloFragment: ModoFilmeFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //Inflando a view
        val layoutFragment = inflater.inflate(R.layout.fragment_modo_titulo, null)

        activity?.toolbar?.subtitle = "Modo título"

        // Obtendo a view do layout
        val edit_text_id_filme = layoutFragment.findViewById<TextView>(R.id.edit_text_titulo_filme)
        val buscarButton = layoutFragment.findViewById<TextView>(R.id.buscarButton)

        buscarButton.setOnClickListener(){
            //Mostrar confirmação de click
            Toast.makeText(layoutFragment.context,"Clicou no botão",Toast.LENGTH_SHORT).show()
        }

        return layoutFragment
    }

    override fun buscarFilme(view: View) {

    }
}