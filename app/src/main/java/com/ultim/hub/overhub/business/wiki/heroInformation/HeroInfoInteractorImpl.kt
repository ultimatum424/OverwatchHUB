package com.ultim.hub.overhub.business.wiki.heroInformation

import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroModel
import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroSkillDescriptionModel
import com.ultim.hub.overhub.presentation.wiki.hero.WikiHeroSkillModel
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HeroInfoInteractorImpl @Inject constructor(): HeroInfoInteractor {

    private val model = WikiHeroModel("Кулак Смерти",
            "«Прогресс невозможен без жертв»",
            "",
            "Кулак Смерти — это титул, передаваемый владельцу одноименной перчатки. По словам Криса Метцена, Кулаком Смерти может стать кто угодно, как Зеленый Фонарь или Флэш.[1] Сейчас Кулаком Смерти является африканец Аканде Огундиму, до этого у перчатки было два владельца. s",
            listOf(
                    WikiHeroSkillDescriptionModel("Роль:", "Штурм"),
                    WikiHeroSkillDescriptionModel("Дата выхода", "27 июля 2017"),
                    WikiHeroSkillDescriptionModel("Суммарное здоровье", "250"),
                    WikiHeroSkillDescriptionModel("Базовое здоровье", "250"),
                    WikiHeroSkillDescriptionModel("Броня","0"),
                    WikiHeroSkillDescriptionModel("Щиты","0 (до 150)"),
                    WikiHeroSkillDescriptionModel("Быстрый удар:","30"),
                    WikiHeroSkillDescriptionModel("Скорость передвижения", "5,5")),
            listOf(WikiHeroSkillModel("Бомбарда", "", "Левая рука Кулака Смерти – усовершенствованный протез со встроенной бомбардой, которая имеет небольшую дальность стрельбы и автоматически восстанавливает заряд.",
                    listOf(WikiHeroSkillDescriptionModel("Урон", "до 66 ед за выстрел"),
                            WikiHeroSkillDescriptionModel("Обойма", "4"),
                            WikiHeroSkillDescriptionModel("Скорострельность", "2 выстрела в сек"),
                            WikiHeroSkillDescriptionModel("Перезарядка", "0,65 сек (1 патрон), макс. — 2.6 сек"))),
                    WikiHeroSkillModel("Реактивный удар", "", "После подготовки Кулак Смерти бросается вперед и отбрасывает противника. Пораженный противник получает дополнительный урон, если врезается в стену.",
                            listOf(WikiHeroSkillDescriptionModel("Урон", "49-100 (+49-150 если враг врезается в стену)"),
                                    WikiHeroSkillDescriptionModel("Перезарядка", "4 сек"),
                                    WikiHeroSkillDescriptionModel("Радиус", "11-30 м"))))
    )

    override fun getHeroInfo(id: Int): Single<WikiHeroModel> {
        return Single.timer(1, TimeUnit.SECONDS).map {model}
    }

}