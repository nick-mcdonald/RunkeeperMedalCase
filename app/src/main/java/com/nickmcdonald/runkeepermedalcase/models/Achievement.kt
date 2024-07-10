package com.nickmcdonald.runkeepermedalcase.models

import android.media.Image

import java.util.Date
import kotlin.time.Duration

sealed class AchievementValue {
    class Time(var time: Duration) : AchievementValue()
    class Distance(var distance: Int): AchievementValue()
}

data class Achievement(
    val sortOrder: Int,
    val name: String,
    val imageName: String,
    var achievedAt: Date? = null,
    var best: AchievementValue? = null,
) {

}

typealias AchievementList = Map<String, List<Achievement>>

val achievements: AchievementList = mapOf(
    "Personal Records" to listOf(
        Achievement(sortOrder = 1, name = "Longest Run", imageName = "longest_run.png"),
        Achievement(sortOrder = 2, name = "Highest Elevation", imageName = "highest_elevation.png"),
        Achievement(sortOrder = 3, name = "Fastest 5K", imageName = "fastest_5k.png"),
        Achievement(sortOrder = 4, name = "Fastest 10k", imageName = "fastest_10k.png"),
        Achievement(sortOrder = 5, name = "Half Marathon", imageName = "fastest_half_marathon.png"),
        Achievement(sortOrder = 6, name = "Marathon", imageName = "fastest_marathon.png"),
    ),
    "Virtual Races" to listOf(
        Achievement(sortOrder = 1, name = "Virtual Half Marathon Race", imageName = "virtual_half_marathon_race.png"),
        Achievement(sortOrder = 2, name = "Tokyo-Hakone Ekiden 2020", imageName = "tokyo_kakone_ekiden.png"),
        Achievement(sortOrder = 3, name = "Virtual 10k Race", imageName = "virtual_10k_race.png"),
        Achievement(sortOrder = 4, name = "Hakone Ekiden", imageName = "hakone_ekiden.png"),
        Achievement(sortOrder = 5, name = "Mizuno Singapore Ekidon 2015", imageName = "mizuno_singapore_ekiden.png"),
        Achievement(sortOrder = 6, name = "Virtual 5K Race", imageName = "virtual_5k_race.png"),
    ),
)