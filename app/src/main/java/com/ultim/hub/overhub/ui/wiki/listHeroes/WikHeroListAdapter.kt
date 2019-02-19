package com.ultim.hub.overhub.ui.wiki.listHeroes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.presentation.wiki.listHeroes.WikiListHeroesPresenter
import kotlinx.android.synthetic.main.wiki_heroes_list_item.view.*

class WikHeroListAdapter(val presenter: WikiListHeroesPresenter): RecyclerView.Adapter<WikHeroListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wiki_heroes_list_item, parent, false))
        return root
    }

    override fun getItemCount(): Int = presenter.getHeroesListSize()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = presenter.getHeroes()[position].name
        holder.image.setImageResource(presenter.getHeroes()[position].logo)
        //holder.cardColor.setCardBackgroundColor(Color.parseColor(presenter.getHeroes()[position].mainColor))
        holder.card.setOnClickListener { presenter.onClick() }

    }


    class ViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){
        val title = itemView.wiki_heroes_list_item_name!!
        val image = itemView.wiki_heroes_list_item_logo!!
        val mainColor = itemView.wiki_heros_list_item_main!!
        val cardColor = itemView.wiki_heros_list_item_card!!
        val card = itemView.wiki_heros_list_item_card!!
    }
}