package com.nickmcdonald.runkeepermedalcase

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.nickmcdonald.runkeepermedalcase.models.achievements
import com.nickmcdonald.runkeepermedalcase.ui.MedalCase
import com.nickmcdonald.runkeepermedalcase.ui.theme.RunKeeperTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RunkeeperApp(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
                title = {
                        Text(text = "Achievements", style = RunKeeperTypography.titleLarge)
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "",
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "",
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        MedalCase(
            achievementList = achievements,
            innerPadding = innerPadding
        )
    }
}