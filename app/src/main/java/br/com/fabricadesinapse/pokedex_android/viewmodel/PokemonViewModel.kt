package br.com.fabricadesinapse.pokedex_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fabricadesinapse.pokedex_android.api.api_url.ApiUrlBase
import br.com.fabricadesinapse.pokedex_android.api.model.Pokemon001
//import br.com.fabricadesinapse.pokedex_android.api.model.PokemonType

//class PokemonViewModel : ViewModel() {
//    var pokemons = MutableLiveData<List<Pokemon001?>>()
//
//    init {
//        Thread(Runnable {
//            loadPokemons()
//        }).start()
//    }
//
//    private fun loadPokemons() {
//        val pokemonsApiResult = ApiUrlBase.listPokemons()
//
//        pokemonsApiResult?.results?.let {
//            pokemons.postValue(it.map { pokemonResult ->
//                val number = pokemonResult.url
//                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
//                    .replace("/", "").toInt()
//
//                val pokemonApiResult = ApiUrlBase.getPokemon(number)
//
//                pokemonApiResult?.let {
//                    Pokemon001(
//                        pokemonApiResult.id,
//                        pokemonApiResult.name,
//                        pokemonApiResult.types.map { type ->
//                            type.type
//                        }
//                    )
//                }
//            })
//        }
//    }
//}
