package br.com.zup.pizzariasimcity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.pizzariasimcity.FragmentClick
import br.com.zup.pizzariasimcity.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), FragmentClick {
     lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, ProdutoFragment())
            .commit()

    }

    override fun onClickFragment(texto: String) {
        val fragmentoDetalhe = DetalheFragment().apply {
            arguments = Bundle().apply {
                putString("TEXTO", texto)
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, fragmentoDetalhe)
            .addToBackStack("Detalhe")
            .commit()
    }
}