/*

package br.edu.ifsp.scl.filmesomdbapi.retrofit

import android.widget.Toast
import br.edu.ifsp.scl.filmesomdbapi.Constantes.URL_BASE
import br.edu.ifsp.scl.filmesomdbapi.MainActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Tradutor(val mainActivity: MainActivity) {


    // Cria um objeto Retrofit usando a URL base.
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(URL_BASE).build()
    // Cria um objeto, a partir da Interface Retrofit, que contém as funções de requisição
    val servicoAPI: ServicoAPI = retrofit.create(ServicoAPI::class.java)


    fun traduzir(palavraOrigem: String, idiomaOrigem: String, idiomaDestino: String) {
    /*Chama a função de requisição definida na Interface passando os parâmetros escolhidos pelo usuário e
    enfileira a requisição que recebe um objeto de uma implementação anônima de Callback<ResponseBody>*/
        servicoAPI.getTraducaoByPath(idiomaOrigem, palavraOrigem, idiomaDestino).enqueue(
            object : Callback<ResponseBody> {
                // Função chamada no caso de erro
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    //mainActivity.menuLateralDrawerLayout.snackbar("Erro na resposta - Retrofit")
                    //Mostrar msg
                    Toast.makeText(mainActivity.applicationContext,"Clicou no botão", Toast.LENGTH_SHORT).show()
                }
                // Função chamada no caso de resposta
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    try {
        // Cria um objeto Gson que consegue fazer reflexão de um Json para Data Class
                        val gson: Gson = Gson()
// Reflete a resposta (que é um Json) num objeto da classe Resposta
                        val resposta: Resposta = gson.fromJson(response.body()?.string(), Resposta::class.java)
// StringBuffer para armazenar o resultado das traduções
                        var traduzidoSb = StringBuffer()
// Parseando o objeto e adicionando as traduções ao StringBuffer O(N^5)
                        resposta.results?.forEach {
                            it?.lexicalEntries?.forEach {
                                it?.entries?.forEach {
                                    it?.senses?.forEach {
                                        it?.translations?.forEach {
                                            traduzidoSb.append("${it?.text}, ")
                                        }
                                    }
                                }
                            }
                        }
// Enviando as tradução ao Handler da thread de UI para serem mostrados na tela
                        mainActivity.tradutoHandler.obtainMessage(
                            MainActivity.codigosMensagen.RESPOSTA_TRADUCAO,
                            traduzidoSb.toString().substringBeforeLast(',')
                        ).sendToTarget()
                    } catch (jse: JSONException) {
                        mainActivity.mainLl.snackbar("Erro na resposta - Retrofit")
                    }
                }
            } // Fim da classe anônima
        ) // Fim dos parâmetros de enqueue
    } // Fim da função traduzir
}


*/