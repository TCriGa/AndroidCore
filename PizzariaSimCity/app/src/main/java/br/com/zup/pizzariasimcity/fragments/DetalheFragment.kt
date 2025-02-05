package br.com.zup.pizzariasimcity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.pizzariasimcity.Pizza
import br.com.zup.pizzariasimcity.databinding.FragmentDetalheBinding



class DetalheFragment : Fragment() {
    private lateinit var binding: FragmentDetalheBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentDetalheBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pizzaRecebida = arguments?.getParcelable<Pizza>("PIZZA_MARGUERITA")

        if (pizzaRecebida != null){
        binding.tvMensagemDetalhe.text = pizzaRecebida.getDescricaoPizza()
    }}

}