package br.com.fabricadesinapse.pokedex_android.adapterPokemon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fabricadesinapse.pokedex_android.R
import br.com.fabricadesinapse.pokedex_android.api.model_json.JsonPokemon

class AdapterPokemon(

    /* Variáveis de Escopo Global: */
    private val context: Context,
    private var listPokemon: MutableList<JsonPokemon>

) : RecyclerView.Adapter<AdapterPokemon.ViewHolderPokemon>() {

   // class ViewHolderPokemon(itemView: View) : RecyclerView.ViewHolder(itemView) {
   class ViewHolderPokemon(var view: View) : RecyclerView.ViewHolder(view) {

//        fun bindView(item: Pokemon?) = with(itemView) {
//            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
//            val tvNumber = findViewById<TextView>(R.id.tvNumber)
//            val tvName = findViewById<TextView>(R.id.tvName)
//            val tvType1 = findViewById<TextView>(R.id.tvType1)
//            val tvType2 = findViewById<TextView>(R.id.tvType2)
//
//            item?.let {
//                Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)
//
//                tvNumber.text = "Nº ${item.formattedNumber}"
//                tvName.text = item.formattedName
//                tvType1.text = item.types[0].name.capitalize()
//
//                if (item.types.size > 1) {
//                    tvType2.visibility = View.VISIBLE
//                    tvType2.text = item.types[1].name.capitalize()
//                } else {
//                    tvType2.visibility = View.GONE
//                }
//            }
//        }

       var namePokemon: TextView? = null

       init {
           namePokemon = view.findViewById(R.id.tvName)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPokemon {

        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.pokemon_item, parent, false)
        return ViewHolderPokemon(view)

    }

    override fun onBindViewHolder(holder: ViewHolderPokemon, position: Int) {
        var pokemon = listPokemon.get(position)
        holder.namePokemon?.text = pokemon.name
    }

    override fun getItemCount(): Int {
        return listPokemon.size
    }
}
