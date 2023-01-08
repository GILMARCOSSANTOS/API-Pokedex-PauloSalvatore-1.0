package br.com.fabricadesinapse.pokedex_android.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fabricadesinapse.pokedex_android.R
import br.com.fabricadesinapse.pokedex_android.api.adapterr.PokemonAdapter
import br.com.fabricadesinapse.pokedex_android.api.api_url.ApiUrlBase
import br.com.fabricadesinapse.pokedex_android.api.model.Pokemon001
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import br.com.fabricadesinapse.pokedex_android.viewmodel.PokemonViewModel
import br.com.fabricadesinapse.pokedex_android.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvPokemons)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    private lateinit var listUsersJson: List<Pokemon001>
    private var pokemonAdapter: PokemonAdapter? = null
    private lateinit var recyclerViewUsers: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingsRecyclerViewUsers()

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it as List<Pokemon001?>)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon001?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}

private fun settingsRecyclerViewUsers() {
    listUsersJson = mutableListOf()
    recyclerViewUsers = findViewById(R.id.rvPokemons)

    recyclerViewUsers.layoutManager = LinearLayoutManager(this@MainActivity)
    pokemonAdapter = PokemonAdapter(
        this,
        listUsersJson
    )
    recyclerViewUsers.adapter = pokemonAdapter
}

private fun getUsersApi() {
    ApiUrlBase.apiServicePokemon.listPokemons()
        .enqueue(object :
            Callback<Callback<Pokemon001>> {
            override fun onResponse(
                call: Call<MutableList<Pokemon001>>,
                response: Response<MutableList<Pokemon001>>
            ) {
                val responseUseres = response.body()
                //  listUsersJson.clear()
                responseUseres?.let {
                    // listUsersJson.addAll(it)
                    pokemonAdapter?.notifyDataSetChanged()
                    println("Resposta da API = " + responseUseres)
                }
            }

            override fun onFailure(call: Call<MutableList<Pokemon001>>, t: Throwable) {
                Log.e("Error", t.localizedMessage)
            }
        })}
}
