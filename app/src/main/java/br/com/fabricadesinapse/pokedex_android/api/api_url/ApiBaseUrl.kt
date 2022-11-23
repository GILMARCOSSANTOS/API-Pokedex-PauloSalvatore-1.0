package br.com.fabricadesinapse.pokedex_android.api.api_url

import br.com.fabricadesinapse.pokedex_android.api.model_json.PokemonJson
import br.com.fabricadesinapse.pokedex_android.api.model_json.PokemonsJson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBaseUrl {
    private val service: ApiRelativeUrl

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiRelativeUrl::class.java)
    }

    fun listPokemons(limit: Int = 5): PokemonsJson? {
        val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemon(number: Int): PokemonJson? {
        val call = service.getPokemon(number)

        return call.execute().body()
    }
}
