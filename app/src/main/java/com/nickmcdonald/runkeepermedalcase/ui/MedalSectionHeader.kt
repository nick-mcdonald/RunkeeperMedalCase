package com.nickmcdonald.runkeepermedalcase.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nickmcdonald.runkeepermedalcase.models.Achievement

@Composable
fun MedalSectionHeader(
    name: String,
    achievements: List<Achievement>,
) {
    val numAchieved = achievements.map { if(it.achievedAt != null) 1 else 0 }.sum()

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .height(40.dp)
            .padding(8.dp)
    ){
        Text(text = name, color = MaterialTheme.colorScheme.onSecondaryContainer)
        Spacer(modifier = Modifier.weight(weight = 1F))
        Text("$numAchieved of ${achievements.count()}", color = MaterialTheme.colorScheme.onTertiaryContainer)
    }
}