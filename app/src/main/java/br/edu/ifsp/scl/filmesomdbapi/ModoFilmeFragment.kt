package br.edu.ifsp.scl.appfilmes

import android.support.v4.app.Fragment
import android.view.View

abstract class ModoFilmeFragment: Fragment() {

    abstract fun buscarFilme(view: View)

}