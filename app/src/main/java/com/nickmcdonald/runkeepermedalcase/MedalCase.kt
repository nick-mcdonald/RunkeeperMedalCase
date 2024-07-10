package com.nickmcdonald.runkeepermedalcase

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val sections = (0 until 25).toList().chunked(5)

@Composable
fun MedalCase(innerPadding: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = innerPadding,
    ) {
        sections.forEachIndexed { sectionIndex, sectionItems ->
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    "This is section $sectionIndex",
                    Modifier
                        .border(width=1.dp, color=Color.Gray)
                        .height(80.dp)
                        .wrapContentSize()
                )
            }

            items(
                sectionItems.count(),
                span = { GridItemSpan(1) }
            ) { index ->
                Text(
                    "Item $index",
                    Modifier
                        .border(1.dp, Color.Blue)
                        .height(80.dp)
                        .wrapContentSize()
                )
            }
        }
    }
}