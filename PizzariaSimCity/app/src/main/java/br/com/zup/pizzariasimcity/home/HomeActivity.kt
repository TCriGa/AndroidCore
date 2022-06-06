package br.com.zup.pizzariasimcity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.pizzariasimcity.FragmentoClick
import br.com.zup.pizzariasimcity.Pizza
import br.com.zup.pizzariasimcity.R
import br.com.zup.pizzariasimcity.databinding.ActivityHomeBinding
import br.com.zup.pizzariasimcity.fragments.DetalheFragment
import br.com.zup.pizzariasimcity.fragments.ProdutoFragment

class HomeActivity : AppCompatActivity(), FragmentoClick {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //gerenciador de fragmentos
        supportFragmentManager
            .beginTransaction() //Inicio
            .add(binding.container.id,ProdutoFragment()) //Adiciono
            .commit() // Comito
    }
//Activitys trabalha com instancia.
    override fun clickFragmentos(mensagem: String) { //Trabalhando com fragmentos é argumentos
    val pizzaMarguerita = Pizza("Marguerita", mensagem)
        val fragmentoDetalhe = DetalheFragment().apply {
            arguments = Bundle().apply {
                putParcelable("PIZZA_MARGUERITA", pizzaMarguerita)
            }
        }

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, fragmentoDetalhe)
            .commit()
    }
}