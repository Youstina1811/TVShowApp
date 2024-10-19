package sheridan.botrosy.tvshowapp.ui.theme.play

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import sheridan.botrosy.tvshowapp.R
import sheridan.botrosy.tvshowapp.domain.Choice
//import sheridan.botrosy.tvshowapp.ui.theme.common.ChoiceToImage
import sheridan.botrosy.tvshowapp.ui.theme.common.GameTopBar
//import sheridan.botrosy.tvshowapp.ui.theme.common.choiceToString
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp

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
                scrollBehavior = TODO(),
                onNavigateBack = TODO()
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
