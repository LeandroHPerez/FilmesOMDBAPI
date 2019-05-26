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
import kotlinx.android.synthetic.main.fragment_modo_titulo.view.*
import kotlinx.android.synthetic.main.frame_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.design.snackbar


class ModoTituloFragment: ModoFilmeFragment() {
    var movie : Movie = Movie()

    //private val movieService = MovieService(mainActivity)

    private val movieService = MovieService()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {




        //Inflando a view
        val layoutFragment = inflater.inflate(R.layout.fragment_modo_titulo, null)

        activity?.toolbar?.subtitle = "Modo título"

        // Obtendo a view do layout
        val edit_text_id_filme = layoutFragment.findViewById<TextView>(R.id.edit_text_titulo_filme)



        val buscarButton = layoutFragment.findViewById<TextView>(R.id.buscarButton)

        //botão ModoTitulo
        buscarButton.setOnClickListener(){
            //Mostrar confirmação de click
            //Toast.makeText(layoutFragment.context,"Clicou no botão ModoTitulo", Toast.LENGTH_SHORT).show()


            // Testa se o usuário digitou alguma coisa para buscar
            if (edit_text_id_filme.text.isNotEmpty()) {
                //movieService.buscarFilmeComOTitulo(edit_text_id_filme.text.toString())

                buscar(edit_text_id_filme.text.toString())


            } else {
                // Senão, mostra uma mensagem na parte debaixo do LinearLayout
                //mainView.snackbar("Digite um título a ser buscado")
                //edit_text_id_filme.snackbar("Digite um título a ser buscado")
                Toast.makeText(layoutFragment.context,"Digite um título a ser buscado",Toast.LENGTH_SHORT).show()
            }


        }


        registrarCallBack(layoutFragment)



        /*


        var gt = this.arguments?.getString("test")
        Log.d("tag_minha", "gtaaaaaaaaaaaaaaaaa")
        Log.d("tag_minha", "gtaaaaaaaaaaaaaaaaa: " + gt)
        //println(gt)

        */

        return layoutFragment
    }

    override fun buscarFilme(view: View) {

    }




    fun carregarValores(view: View, movie: Movie) {
        if(movie.title.isNotEmpty()) { //verifica se retornou um filme
            view.title_textView.text = movie.title
            view.year_textView.text = movie.year
            view.released_textView.text = movie.released
            view.director_textView.text = movie.director
            view.actors_textView.text = movie.actors
            view.idioma_textView.text = movie.language
            view.country_textView.text = movie.country
            view.avaliacao_textView.text = movie.ratings.first().source
            view.notaImdb_textView.text = movie.imdbRating
            view.type_textView.text = movie.typeMovie
            view.produtora_textView.text = movie.production
            view.website_textView.text = movie.website
        }
        else {
            Toast.makeText(view.context,"Filme não localizado",Toast.LENGTH_SHORT).show()
            limpar(view)
        }
    }


    fun limpar(view: View) {
            view.title_textView.text = ""
            view.year_textView.text = ""
            view.released_textView.text = ""
            view.director_textView.text = ""
            view.actors_textView.text = ""
            view.idioma_textView.text = ""
            view.country_textView.text = ""
            view.avaliacao_textView.text = ""
            view.notaImdb_textView.text = ""
            view.type_textView.text = ""
            view.produtora_textView.text = ""
            view.website_textView.text = ""
    }



    private fun buscar (palavraBusca: String) {

        movieService.buscarFilmeComOTitulo(palavraBusca)
    }


    private fun registrarCallBack (layoutFragment: View) {

        movieService.responseOmdb = object : MovieService.ResponseOmdb {
            override fun onResponse(movie: Movie) {
                //Toast.makeText(this@MainActivity, "sucesso", Toast.LENGTH_LONG).show()
                if (movie != null) {
                    Log.d("tag_minha", "entrou")
                    Log.d("tag_minha",movie.title)
                    Log.d("tag_minha",movie.year)
                    Log.d("tag_minha",movie.released)
                    Log.d("tag_minha",movie.genre)
                    Log.d("tag_minha",movie.director)
                    Log.d("tag_minha",movie.poster)
                    Log.d("tag_minha",movie.website)

                    carregarValores(layoutFragment, movie)
                }
            }

            override fun onResponseFail(error: Throwable) {

                Log.d("tag_minha", "Erro na consulta do filme")
                //Toast.makeText(layoutFragment.context,"Erro na consulta do filme",Toast.LENGTH_SHORT).show()
            }
        }

    }




}