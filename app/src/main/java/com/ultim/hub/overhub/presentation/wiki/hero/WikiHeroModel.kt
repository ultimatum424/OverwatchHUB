package com.ultim.hub.overhub.presentation.wiki.hero

data class WikiHeroModel(val name: String,
                         val quote: String,
                         val portraitUrl: String,
                         val history: String,
                         val baseDescriptionTable: List<WikiHeroSkillDescriptionModel>,
                         val skillTable: List<WikiHeroSkillModel>)

data class WikiHeroSkillModel(val title: String,
                              val iconUrl: String,
                              val text: String,
                              val descriptionTable: List<WikiHeroSkillDescriptionModel>)

data class WikiHeroSkillDescriptionModel(val title: String,
                                         val text: String)