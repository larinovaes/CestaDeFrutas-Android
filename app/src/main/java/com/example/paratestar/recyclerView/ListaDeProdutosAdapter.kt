package com.example.paratestar.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.paratestar.R
import com.example.paratestar.model.Produto

class ListaDeProdutosAdapter(
    private val context: Context,
     produto: List<Produto>
) : RecyclerView.Adapter<ListaDeProdutosAdapter.ViewHolder>() {

    private val produtos = produto.toMutableList()

    //essa view pode acessar todas
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.nomeProduto)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.descricaoProduto)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.valorProduto)
                valor.text = produto.valor.toPlainString() //para transforamar em uma string
        }
    }
    //as views que criamos para nosso layout

    //ele é responsavel por pegar as views fazer as modificações no adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    // ele é responsavel por indicar a posição de cada view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position] // chamar o vetor para ele dizer quaç é a posição
        holder.vincula(produto)
    }

    // ele apresenta quantos itens queremos apresentar dentro adapter
    override fun getItemCount(): Int = produtos.size

    fun atualizarLista(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
