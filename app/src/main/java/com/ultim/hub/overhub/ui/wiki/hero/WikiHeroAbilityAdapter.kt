package com.ultim.hub.overhub.ui.wiki.hero

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.presentation.wiki.hero.WIkiHeroPresenter
import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroSkillDescriptionModel
import kotlinx.android.synthetic.main.wiki_hero_ability_item.view.*
import javax.inject.Inject

class WikiHeroAbilityAdapter @Inject constructor(
        val presenter: WIkiHeroPresenter
): RecyclerView.Adapter<WikiHeroAbilityAdapter.ViewHolder>() {

    private var list: MutableList<WikiHeroSkillDescriptionModel> = mutableListOf()

    fun reloadData(data: List<WikiHeroSkillDescriptionModel>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wiki_hero_ability_item, parent, false))
        return root
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.text.text = list[position].text
    }

    class ViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.wiki_hero_description_item_title
        val text: TextView = itemView.wiki_hero_description_item_title_content
    }

}