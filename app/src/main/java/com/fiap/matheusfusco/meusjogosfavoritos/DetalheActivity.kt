package com.fiap.matheusfusco.meusjogosfavoritos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detalhe.*
import kotlinx.android.synthetic.main.content_detalhe.*
import model.Jogo

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalhe)

        setSupportActionBar(toolbar)

        val jogo = intent.getParcelableExtra<Jogo>("jogo")
        toolbar_layout.title = jogo.titulo
        ivBanner.setImageDrawable(ContextCompat.getDrawable(this, jogo.bannerId))
        tvDescricao.text = jogo.descricao

        fab.setOnClickListener { view ->


            try {
                val text = "Olá meu jogo preferido é ${jogo.titulo}"// Replace with your message.
                val toNumber = "XXXXXX"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
