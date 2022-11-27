//package br.com.fabricadesinapse.pokedex_android.viewmodel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import br.com.fabricadesinapse.pokedex_android.api.api_url.ApiBaseUrl
//import br.com.fabricadesinapse.pokedex_android.api.property_setting.Js
//
//class PokemonViewModel : ViewModel() {
//    var pokemons = MutableLiveData<List<Pokemon?>>()
//
////    init {
////        Thread(Runnable {
////           // loadPokemons()
////        }).start()
////    }
//
////    private fun loadPokemons() {
////        val pokemonsApiResult = ApiBaseUrl.listPokemons()
////
////        pokemonsApiResult?.results?.let {
////            pokemons.postValue(it.map { pokemonResult ->
////                val number = pokemonResult.url
////                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
////                    .replace("/", "").toInt()
////
////                val pokemonApiResult = number?.let { it1 -> ApiBaseUrl.getPokemon(it1) }
////
////                pokemonApiResult?.let {
////                    pokemonApiResult.id.let { it1 ->
////                        pokemonApiResult.name.let { it2 ->
////                            pokemonApiResult.types.let { it3 ->
////                                Pokemon(
////                                    it1,
////                                    it2,
////                                    it3.map { type ->
////                                        type.type
////                                    }
////                                )
////                            }
////                        }
////                    }
////                }
////            })
////        }
////    }
//}
