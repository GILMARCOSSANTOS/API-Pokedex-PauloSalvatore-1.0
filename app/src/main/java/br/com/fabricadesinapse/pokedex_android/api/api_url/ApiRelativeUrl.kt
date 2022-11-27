package br.com.fabricadesinapse.pokedex_android.api.api_url

import br.com.fabricadesinapse.pokedex_android.api.model_json.JsonPokemon
import retrofit2.Call
import retrofit2.http.GET


interface ApiRelativeUrl {
//    @GET("pokemon")
//    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsJson>
//
//    @GET("pokemon/{number}")
//    fun getPokemon(@Path("number") number: Int): Call<PokemonJson>

    @GET("pokemon/ditto")
    fun getPokemonUrlRelative(): Call<MutableList<JsonPokemon>>
}
