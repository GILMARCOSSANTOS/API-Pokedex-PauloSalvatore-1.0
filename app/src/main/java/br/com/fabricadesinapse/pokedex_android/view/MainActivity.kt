package br.com.fabricadesinapse.pokedex_android.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fabricadesinapse.pokedex_android.R
import br.com.fabricadesinapse.pokedex_android.adapterPokemon.AdapterPokemon
import br.com.fabricadesinapse.pokedex_android.api.api_url.ApiBaseUrl
import br.com.fabricadesinapse.pokedex_android.api.model_json.JsonPokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var listPokemon: MutableList<JsonPokemon> = mutableListOf<JsonPokemon>()
    private lateinit var recyclerViewPokemon: RecyclerView
    private var adapterPokemon: AdapterPokemon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadPokemon()
        loadRecyclerView()

//        viewModel.pokemons.observe(this, Observer {
//            loadRecyclerView(it)
//        })
    }

    private fun loadRecyclerView() {
        listPokemon = mutableListOf()
        recyclerViewPokemon = findViewById(R.id.rvPokemons)

        recyclerViewPokemon.layoutManager = LinearLayoutManager(this@MainActivity)
        adapterPokemon = AdapterPokemon(
            this,
            listPokemon
        )
        recyclerViewPokemon.adapter = adapterPokemon
    }

    private fun loadPokemon() {
        ApiBaseUrl.apiServicePokemons.getPokemonUrlRelative()
            .enqueue(object : Callback<MutableList<JsonPokemon>> {

                override fun onFailure(call: Call<MutableList<JsonPokemon>>, t: Throwable) {
                    Log.e("Error", t.localizedMessage)
                    println("Resposta de Erro API" )
                }

                override fun onResponse(
                    call: Call<MutableList<JsonPokemon>>,
                    response: Response<MutableList<JsonPokemon>>
                ) {
                    val responseJsonPokemon = response.body()
                    listPokemon.clear()
                    responseJsonPokemon.let {
                        listPokemon.addAll(listOf(JsonPokemon()))
                        adapterPokemon?.notifyDataSetChanged()
                    }
                }
            })
    }
}






