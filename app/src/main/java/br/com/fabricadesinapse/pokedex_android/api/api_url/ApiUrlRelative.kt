package br.com.fabricadesinapse.pokedex_android.api.api_url

import br.com.fabricadesinapse.pokedex_android.api.model.Pokemon001
import br.com.fabricadesinapse.pokedex_android.api.model.PokemonApiResult
import br.com.fabricadesinapse.pokedex_android.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiUrlRelative {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<Pokemon001>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int): Call<PokemonApiResult>
}
