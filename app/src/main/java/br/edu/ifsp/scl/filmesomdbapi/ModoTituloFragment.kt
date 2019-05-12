package br.edu.ifsp.scl.filmesomdbapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import br.edu.ifsp.scl.appfilmes.ModoFilmeFragment
import br.edu.ifsp.scl.filmesomdbapi.model.Movie
import br.edu.ifsp.scl.filmesomdbapi.retrofit.MovieService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.frame_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.design.snackbar


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
            Toast.makeText(layoutFragment.context,"Clicou no botão Modo Filme",Toast.LENGTH_SHORT).show()

            // Testa se o usuário digitou alguma coisa para buscar
            if (edit_text_id_filme.text.isNotEmpty()) {
                //movieService.buscarFilmeComOTitulo(searchField.text.toString())
            } else {
                // Senão, mostra uma mensagem na parte debaixo do LinearLayout
                //mainView.snackbar("Digite um título a ser buscado")
                //edit_text_id_filme.snackbar("Digite um título a ser buscado")
                Toast.makeText(layoutFragment.context,"Digite um título a ser buscado",Toast.LENGTH_SHORT).show()
            }


            fazTudo(layoutFragment)
        }

        return layoutFragment
    }

    override fun buscarFilme(view: View) {

    }


    private fun fazTudo(view: View) {
/*
        val activity = activity as MainActivity?

        val movieService = MovieService(activity!!)

        movieService.responseOmdb = object : MovieService.ResponseOmdb {
            override fun onResponse(movie: Movie) {
                //Toast.makeText(this@MainActivity, "sucesso", Toast.LENGTH_LONG).show()
                if (movie != null) {
                    Log.d("tag",movie.title)
                    Log.d("tag",movie.year)
                    Log.d("tag",movie.released)
                    Log.d("tag",movie.genre)
                    Log.d("tag",movie.director)
                    Log.d("tag",movie.poster)
                    Log.d("tag",movie.website)
                }
//                substituiFragment()*/
            }






}