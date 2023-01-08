package br.com.fabricadesinapse.pokedex_android.api.api_url

import br.com.fabricadesinapse.pokedex_android.api.model.Pokemon001
import br.com.fabricadesinapse.pokedex_android.api.model.PokemonApiResult
import br.com.fabricadesinapse.pokedex_android.api.model.PokemonsApiResult
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUrlBase {
    private val service: ApiUrlRelative

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiUrlRelative::class.java)
    }
    fun listPokemons(limit: Int = 151): Pokemon001? {
        val call = service.listPokemons(limit)

        return call.execute().body()
    }
    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number)

        return call.execute().body()
    }

    private const val BASE_URL: String = "https://pokeapi.co/api/v2/"

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val interceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiServicePokemon: ApiUrlRelative by lazy {
        retrofit.create(ApiUrlRelative::class.java)
    }
}
