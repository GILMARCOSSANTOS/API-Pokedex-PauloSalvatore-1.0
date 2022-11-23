package br.com.fabricadesinapse.pokedex_android.api.api_url

import br.com.fabricadesinapse.pokedex_android.api.model_json.PokemonApiResult
import br.com.fabricadesinapse.pokedex_android.api.model_json.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRelativeUrl {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int): Call<PokemonApiResult>
}
