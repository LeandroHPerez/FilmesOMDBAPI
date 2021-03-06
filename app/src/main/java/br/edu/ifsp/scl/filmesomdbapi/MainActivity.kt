package br.edu.ifsp.scl.filmesomdbapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import br.edu.ifsp.scl.filmesomdbapi.R.id.mainView
import br.edu.ifsp.scl.filmesomdbapi.model.Movie
import br.edu.ifsp.scl.filmesomdbapi.retrofit.MovieService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.frame_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.design.snackbar


//http://www.omdbapi.com/?i=tt3896198&apikey=56c7e1ad


class MainActivity : AppCompatActivity() {

    //private val movieService = MovieService(this)
    private val movieService = MovieService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar
        setSupportActionBar(toolbar) // recupera o componente xml toolbar
        supportActionBar?.title = resources.getString(R.string.app_name_toolbar) // mudando o título da toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val abreFechaToogle: ActionBarDrawerToggle =
            ActionBarDrawerToggle(this, menuLateralDrawerLayout, toolbar, R.string.menu_aberto, R.string.menu_fechado)

        menuLateralDrawerLayout.addDrawerListener(abreFechaToogle)
        abreFechaToogle.syncState()  // Sincroniza ícone na Toolbar com o Menu Lateral

        //Ajustar o listener da NavigationView
        menuNavigationView.setNavigationItemSelectedListener { onNavigationItemSelected(it) }

        // Inicia nesse modo como padrão.
        substituiFragment("MODO_TITULO")


        //Trecho para testes do desenvolvedor
        /*

        searchButton.setOnClickListener {
            // Testa se o usuário digitou alguma coisa para buscar
            Toast.makeText(this,"Clicou", Toast.LENGTH_SHORT).show()

            if (searchField.text.isNotEmpty()) {
                //movieService.buscarFilmeComOTitulo(searchField.text.toString())

                movieService.buscarFilmePorId(searchField.text.toString())
            } else {
                // Senão, mostra uma mensagem na parte debaixo do LinearLayout
                Toast.makeText(this,"É preciso digitar um título a ser buscado", Toast.LENGTH_SHORT).show()
                //mainView.snackbar("É preciso digitar um título a ser buscado")
            }
        }


        movieService.responseOmdb = object : MovieService.ResponseOmdb {
            override fun onResponse(movie: Movie) {
                Toast.makeText(this@MainActivity, "sucesso", Toast.LENGTH_LONG).show()
                if (movie != null) {
                    Log.d("tag_minha",movie.title)
                    Log.d("tag_minha",movie.year)
                    Log.d("tag_minha",movie.released)
                    Log.d("tag_minha",movie.genre)
                    Log.d("tag_minha",movie.director)
                    Log.d("tag_minha",movie.poster)
                    Log.d("tag_minha",movie.website)

                    substituiFragment("MODO_TITULO", movie)
                }
//                substituiFragment()
            }

            override fun onResponseFail(error: Throwable) {
                Toast.makeText(this@MainActivity, "Erro na consulta do filme", Toast.LENGTH_LONG).show()
            }
        }


*/

    }

    private fun substituiFragment(modoFragment: String, movie: Movie){

        // verifica qual fragment vai instanciar
        val modoFilmeFragment = if (modoFragment.equals("MODO_TITULO")) ModoTituloFragment() else ModoIdFragment()


/*
        val testString : String = "example only"

        var bundle = Bundle()
        bundle.putString("test", testString)
        modoFilmeFragment.arguments = bundle
        */










        // Transação para substituição de fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, modoFilmeFragment) //Chama o fragment do modo escolhido
        fragmentTransaction.commit()
    }

    private fun substituiFragment(modoFragment: String){

        // verifica qual fragment vai instanciar
        val modoFilmeFragment = if (modoFragment.equals("MODO_TITULO")) ModoTituloFragment() else ModoIdFragment()

        // Transação para substituição de fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, modoFilmeFragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if(menuLateralDrawerLayout.isDrawerOpen(GravityCompat.START)){
            menuLateralDrawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }

    //Trata cliques na NavigationDrawer
    fun onNavigationItemSelected(item: MenuItem): Boolean {
        var retorno: Boolean = false

        when (item.itemId) {
            R.id.modoTituloMenuItem -> {
                substituiFragment("MODO_TITULO")
                retorno = true
            }
            R.id.modoIdMenuItem -> {
                substituiFragment("MODO_ID")
                retorno = true
            }
            R.id.sairMenuItem -> {
                finish()
                retorno = true
            }
        }

        menuLateralDrawerLayout.closeDrawer(GravityCompat.START)
        return retorno
    }
}