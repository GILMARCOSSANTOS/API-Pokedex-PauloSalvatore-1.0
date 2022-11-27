package br.com.fabricadesinapse.pokedex_android.api.model_json

import com.google.gson.annotations.SerializedName
import java.io.Serializable

//data class PokemonsJson(
//    val count: Int,
//    val next: String?,
//    val previous: String?,
//    val results: List<PokemonResult>
//)

//data class PokemonResult(
//    val name: String,
//    val url: String
//)

 class JsonPokemon(
   // val id: Int,

    @SerializedName("name")
    val name: String? = null

   // val types: List<PokemonTypeSlot>
): Serializable

//data class PokemonTypeSlot(
//    val slot: Int,
//    val type: PokemonType
//)
