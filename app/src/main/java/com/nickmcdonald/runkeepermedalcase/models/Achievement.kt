package com.nickmcdonald.runkeepermedalcase.models

import com.nickmcdonald.runkeepermedalcase.R
import java.time.LocalDate

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

sealed class AchievementValue {
    class Time(var time: Duration) : AchievementValue()
    class Elevation(var height: Int) : AchievementValue()
    class Distance(var distance: Int): AchievementValue()
}

data class Achievement(
    val sortOrder: Int,
    val name: String,
    val imageId: Int,
    var achievedAt: LocalDate? = null,
    var best: AchievementValue? = null,
) {
    fun bestValueAsString() : String {
        return when (best) {
            is AchievementValue.Time -> {
                (best as AchievementValue.Time).time.toComponents {  hours, minutes, seconds, _ ->
                    "${hours}:${minutes.toString().padStart(2,'0')}:${seconds.toString().padStart(2,'0')}"
                }
            }

            is AchievementValue.Elevation -> {
                "${(best as AchievementValue.Elevation).height} ft"
            }

            is AchievementValue.Distance -> {
                "${(best as AchievementValue.Distance).distance} km"
            }

            null -> "Not Yet"
        }
    }
}

typealias AchievementList = Map<String, List<Achievement>>

val achievements: AchievementList = mapOf(
    "Personal Records" to listOf(
        Achievement(sortOrder = 1, name = "Longest Run", imageId = R.drawable.longest_run, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 23705.seconds)),
        Achievement(sortOrder = 2, name = "Highest Elevation", imageId = R.drawable.highest_elevation, achievedAt = LocalDate.of(2022,2, 22), best = AchievementValue.Elevation(height = 2095)),
        Achievement(sortOrder = 3, name = "Fastest 5K", imageId = R.drawable.fastest_5k, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 1705.seconds)),
        Achievement(sortOrder = 4, name = "Fastest 10k", imageId = R.drawable.fastest_10k, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 4036.seconds)),
        Achievement(sortOrder = 5, name = "Half Marathon", imageId = R.drawable.fastest_half_marathon, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 12456.seconds)),
        Achievement(sortOrder = 6, name = "Marathon", imageId = R.drawable.fastest_marathon),
    ),
    "Virtual Races" to listOf(
        Achievement(sortOrder = 1, name = "Virtual Half Marathon Race", imageId = R.drawable.virtual_half_marathon_race, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 0.seconds)),
        Achievement(sortOrder = 2, name = "Tokyo-Hakone Ekiden 2020", imageId = R.drawable.tokyo_kakone_ekiden, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 0.seconds)),
        Achievement(sortOrder = 3, name = "Virtual 10k Race", imageId = R.drawable.virtual_10k_race, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 0.seconds)),
        Achievement(sortOrder = 4, name = "Hakone Ekiden", imageId = R.drawable.hakone_ekiden, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 0.seconds)),
        Achievement(sortOrder = 5, name = "Mizuno Singapore Ekidon 2015", imageId = R.drawable.mizuno_singapore_ekiden, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 0.seconds)),
        Achievement(sortOrder = 6, name = "Virtual 5K Race", imageId = R.drawable.virtual_5k_race, achievedAt = LocalDate.of(2024,7, 10), best = AchievementValue.Time(time = 0.seconds)),
    ),
)