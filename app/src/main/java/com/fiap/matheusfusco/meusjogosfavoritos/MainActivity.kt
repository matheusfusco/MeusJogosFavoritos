package com.fiap.matheusfusco.meusjogosfavoritos

import adapter.JogoAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import model.Jogo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvJogos.adapter = JogoAdapter(this,getJogos(), {
            val intentDetalhe = Intent(this,
                    DetalheActivity::class.java)
            intentDetalhe.putExtra("jogo", it)
            startActivity(intentDetalhe)
        }, {
            Toast.makeText(this, "Delete ${it.titulo}", Toast.LENGTH_LONG).show()
        })
        rvJogos.layoutManager = LinearLayoutManager(this)
    }

    fun getJogos(): List<Jogo> {
        return listOf(
                Jogo(getString(R.string.titulo_god_of_war),
                        getString(R.string.descr_god_of_war),
                        2018,
                        R.drawable.god_of_war,
                        R.drawable.god_of_war_banner),
                Jogo(getString(R.string.pes_2018),
                        getString(R.string.pes_2018_descr),
                        2018,
                        R.drawable.pes_2018,
                        R.drawable.pes_2018_banner)
        )
    }
}