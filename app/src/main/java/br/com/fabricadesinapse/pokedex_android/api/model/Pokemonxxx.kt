package br.com.fabricadesinapse.pokedex_android.api.model

data class Pokemonxxx(
    val number: Int,
    val name: String,
    val types: List<PokemonType>
) {
     val formattedName = name.capitalize()
    val formattedNumber = number.toString().padStart(3, '0')
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}
