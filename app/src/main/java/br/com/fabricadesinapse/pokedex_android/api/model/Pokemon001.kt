package br.com.fabricadesinapse.pokedex_android.api.model


import com.google.gson.annotations.SerializedName

data class Pokemon001(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result001>
)