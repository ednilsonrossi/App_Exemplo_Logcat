package br.edu.ifsp.dmo1.exemplologcat

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.exemplologcat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val TAG = "MY_LOGCAT"
    private lateinit var binding: ActivityMainBinding
    private val options = listOf(
        "Mensagem Geral (verbose)",
        "Depuração",
        "Informações",
        "Avisos",
        "Erro")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Apresentar mensagem no logcat ao carregar o aplicativo
         */
        Log.v(TAG, "Mensagem de uso geral, mostra todas as mensagens de log.");
        Log.d(TAG, "Registros úteis apenas na depuração");
        Log.i(TAG, "Mensagem de informações");
        Log.w(TAG, "Mensagens de aviso");
        Log.e(TAG, "Mensagens de erro");

        /**
         * Configurando o listview para apresentar as opções de mensagem
         * que serão apresentadas na tela. Observa-se que o clique nos
         * itens da listview será tratado pela MainActivity, por isso
         * a MainActivity implementa a interface OnItemClickListener de
         * AdapterView.
         */

        binding.listActions.adapter = MessageLogAdapter(this, options)
        binding.listActions.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        /**
         * Recupera a posição do clique e escreve no logcat qual o
         * item da lista foi clicado. Aqui cada item representa
         * um nível de mensagem do logcat. Ao final é apresentado
         * um toast que informa que o log foi registrado no
         * logcat.
         */

        val message = "Clicou em ${options.get(position)}"

        when (position) {
            0 -> Log.v(TAG, message)
            1 -> Log.d(TAG, message)
            2 -> Log.i(TAG, message)
            3 -> Log.w(TAG, message)
            4 -> Log.e(TAG, message)
        }

        Toast.makeText(this, "A mensagem foi gravada no logcat.", Toast.LENGTH_SHORT).show();
    }
}