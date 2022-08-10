package com.example.pokemonapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.databinding.ItemPokemonBinding


class PokemonAdapter : ListAdapter<PokemonModel, PokemonAdapter.PokemonViewHolder>(
    PokemonDiffCallBack
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class PokemonViewHolder(
        private val binding: ItemPokemonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: PokemonModel) = with(binding) {
            nameTv.text = model.name
        }
    }
}

object PokemonDiffCallBack : DiffUtil.ItemCallback<PokemonModel>() {
    override fun areItemsTheSame(
        oldItem: PokemonModel,
        newItem: PokemonModel
    )
            : Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PokemonModel,
        newItem: PokemonModel
    ): Boolean {
        return oldItem == newItem
    }
}
