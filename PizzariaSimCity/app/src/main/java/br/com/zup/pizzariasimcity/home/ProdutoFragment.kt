package br.com.zup.pizzariasimcity.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.pizzariasimcity.FragmentClick
import br.com.zup.pizzariasimcity.databinding.FragmentProdutoBinding
import java.lang.Exception

class ProdutoFragment : Fragment() {
    private lateinit var binding: FragmentProdutoBinding

    private lateinit var click: FragmentClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            click = context as HomeActivity
        }catch (ex: Exception){
            Log.i("FragmentError", ex.message.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomePizza = binding.tvNomePizza.text.toString()

        binding.ivPizza.setOnClickListener {
            click.onClickFragment(nomePizza)
        }
    }
}