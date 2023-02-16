package com.example.photoeditor.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.photoeditor.databinding.ItemLayoutBinding
import com.example.photoeditor.models.SpecieModel

typealias onItemClick = (specieModel: SpecieModel) -> Unit

class MainAdapter(val onItemClick: onItemClick) : PagingDataAdapter<SpecieModel, MainAdapter.MainViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SpecieModel>() {
            override fun areItemsTheSame(oldItem: SpecieModel, newItem: SpecieModel): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: SpecieModel, newItem: SpecieModel): Boolean = oldItem == newItem
        }
    }

    inner class MainViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.apply {
            name = item?.species_name
            image = item?.species_illustration_photo?.src.toString()
        }

        holder.binding.root.setOnClickListener {
            item?.let { it1 -> onItemClick.invoke(it1) }
        }
    }
}