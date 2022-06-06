package br.com.zup.listacompras.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.listacompras.databinding.ProdutoItemBinding
import br.com.zup.listacompras.model.Produto

class ProdutoAdapter(
    private var listaProduto: MutableList<Produto>
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    //Criar o Objeto e vincula a view(layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ) // Método padrão
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position] //Esse produto está sendo mandado
                                              // para a classe ViewHolder em exibirInformações
        holder.exibirInformacoesView(produto)

    }

    override fun getItemCount(): Int {
        return listaProduto.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun atualizarLisproduto(novaListaProduto: MutableList<Produto>){

        if (listaProduto.size == 0){
            listaProduto = novaListaProduto
        }else{
            listaProduto.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacoesView(produto: Produto) {
            binding.tvNomeProduto.text = produto.getNome()
        }
    }
}