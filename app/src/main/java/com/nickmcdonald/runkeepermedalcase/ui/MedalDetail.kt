package com.nickmcdonald.runkeepermedalcase.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nickmcdonald.runkeepermedalcase.models.Achievement
import com.nickmcdonald.runkeepermedalcase.ui.theme.RunKeeperTypography

@Composable
fun MedalDetail(
    achievement : Achievement,
    modifier: Modifier
) {
    val isFaded = achievement.achievedAt == null

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .alpha(if (isFaded) 0.5F else 1.0F),
    ){
        Image(
            painter = painterResource(achievement.imageId),
            contentDescription = "${achievement.name} image",
            modifier = Modifier.weight(1F),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = achievement.name,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(PaddingValues(top = 8.dp)),
            style = RunKeeperTypography.titleSmall
        )
        Text(
            text = achievement.bestValueAsString(),
            style = RunKeeperTypography.labelSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(PaddingValues(top = 4.dp))
        )
    }
}