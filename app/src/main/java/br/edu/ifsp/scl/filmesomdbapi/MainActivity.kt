package br.edu.ifsp.scl.filmesomdbapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

//http://www.omdbapi.com/?i=tt3896198&apikey=56c7e1ad


class MainActivity : AppCompatActivity() {

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
        abreFechaToogle.syncState()

        //Ajustar o listener da NavigationView
        menuNavigationView.setNavigationItemSelectedListener { onNavigationItemSelected(it) }

        // Inicia nesse modo como padrão.
        substituiFragment("MODO_TITULO")
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