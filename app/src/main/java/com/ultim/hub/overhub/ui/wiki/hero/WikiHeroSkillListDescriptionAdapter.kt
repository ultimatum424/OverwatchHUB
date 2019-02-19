package com.ultim.hub.overhub.ui.wiki.hero

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ultim.hub.overhub.R
import com.ultim.hub.overhub.presentation.wiki.hero.WIkiHeroPresenter
import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroSkillModel
import kotlinx.android.synthetic.main.wiki_hero_skill_item.view.*
import javax.inject.Inject

class WikiHeroSkillListDescriptionAdapter @Inject constructor(
        val presenter: WIkiHeroPresenter
): RecyclerView.Adapter<WikiHeroSkillListDescriptionAdapter.ViewHolder>() {

   private var list: MutableList<WikiHeroSkillModel> = mutableListOf()

    fun reloadData(data: List<WikiHeroSkillModel>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wiki_hero_skill_item, parent, false))
        return root
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.text.text = list[position].text
        holder.description.adapter = WikiHeroAbilityAdapter(presenter)
        holder.description.isNestedScrollingEnabled = false
        holder.description.layoutManager = LinearLayoutManager(holder.description.context)
        val wikiHeroAbilityAdapter = holder.description.adapter as WikiHeroAbilityAdapter
        wikiHeroAbilityAdapter.reloadData(list[position].descriptionTable)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.wiki_hero_skill_title
        //TODO: ADD ICON
        val text: TextView = itemView.wiki_hero_skill_text
        val description: RecyclerView = itemView.wiki_hero_skill_description_recycle
    }
}