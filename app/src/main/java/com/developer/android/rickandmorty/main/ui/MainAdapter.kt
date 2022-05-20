package com.developer.android.rickandmorty.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developer.android.rickandmorty.main.model.Hero
import timber.log.Timber


class MainAdapter(
    val onClick: (Hero) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val heroes = mutableListOf<Hero>()


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.image_view1)
        private val textView1: TextView = itemView.findViewById(R.id.text_view1)
        private val textView2: TextView = itemView.findViewById(R.id.text_view2)

        fun bind(hero: Hero) {
            Glide.with(itemView.context).load(hero.image)
                .into(imageView)
            textView1.text = hero.name
            textView2.text = hero.id.toString()
            itemView.setOnClickListener { onClick.invoke(hero) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val listItem = heroes[position]
        holder.bind(listItem)
    }

    override fun getItemCount() = heroes.size

    fun setData(list: List<Hero>) {
        heroes.clear()
        heroes.addAll(list)
        Timber.i(list.toString())
        notifyDataSetChanged()
    }


}