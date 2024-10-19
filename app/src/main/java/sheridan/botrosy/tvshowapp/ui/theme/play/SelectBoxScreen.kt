@file:Suppress("UNREACHABLE_CODE")

package sheridan.botrosy.tvshowapp.ui.theme.play

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.botrosy.tvshowapp.domain.Choice
import sheridan.botrosy.tvshowapp.ui.theme.common.GameTopBar
import androidx.compose.material3.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBoxScreen(
    selectedBox: Choice,
    onBoxSelect: (Choice) -> Unit,
    onNext: () -> Unit,
    onHelpButtonClick: () -> Unit
) {
    Scaffold(
        topBar = {
            GameTopBar(
                title = "Select a Box",
                onHelpButtonClick = onHelpButtonClick,
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                onNavigateBack = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            for (box in Choice.values().filter { it != Choice.UNKNOWN }) {
                Button(
                    onClick = { onBoxSelect(box) },
                    enabled = selectedBox == Choice.UNKNOWN
                ) {
                    Text(text = box.name)
                }
            }
            Button(
                onClick = onNext,
                enabled = selectedBox != Choice.UNKNOWN
            ) {
                Text("Next")
            }
        }
    }
}
