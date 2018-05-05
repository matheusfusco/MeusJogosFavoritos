package adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fiap.matheusfusco.meusjogosfavoritos.R
import kotlinx.android.synthetic.main.meu_jogo_item.view.*
import model.Jogo

class JogoAdapter(val context: Context,
                  val jogos: List<Jogo>,
                  val listener: (Jogo) -> Unit,
                  val listenerDelete: (Jogo) -> Unit) : RecyclerView.Adapter<JogoAdapter.JogoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.meu_jogo_item, parent, false)
        return JogoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return jogos.size
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val jogo = jogos[position]
        holder?.let {
            holder.bindView(jogo, listener, listenerDelete)
        }
    }

    class JogoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(jogo: Jogo,
                     listener: (Jogo) -> Unit,
                     listenerDelete: (Jogo) -> Unit) = with(itemView) {
            tvTitulo.text = jogo.titulo
            tvDescricao.text = jogo.descricao
            ivFoto.setImageDrawable(ContextCompat.getDrawable(context, jogo.fotoId))
            tvLancamento.setText(context.getString(R.string.lancamento, jogo.anoLancamento))
            ivDelete.setOnClickListener { listenerDelete(jogo) }
            setOnClickListener { listener(jogo) }
        }
    }

}