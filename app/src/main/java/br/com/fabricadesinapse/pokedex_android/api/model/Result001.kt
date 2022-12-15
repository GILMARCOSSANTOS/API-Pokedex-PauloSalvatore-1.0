package br.com.fabricadesinapse.pokedex_android.api.model


import com.google.gson.annotations.SerializedName

data class Result001(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)