package com.nickmcdonald.runkeepermedalcase.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nickmcdonald.runkeepermedalcase.models.AchievementList

@Composable
fun MedalCase(
    achievementList: AchievementList,
    innerPadding: PaddingValues,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = innerPadding,
    ) {
        achievementList.forEach { (sectionName, achievements) ->
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                MedalSectionHeader(name = sectionName, achievements = achievements)
            }

            items(
                items = achievements,
            ) { achievement ->
                MedalDetail(
                    achievement = achievement,
                    modifier = Modifier.height(200.dp)
                )
            }
        }
    }
}