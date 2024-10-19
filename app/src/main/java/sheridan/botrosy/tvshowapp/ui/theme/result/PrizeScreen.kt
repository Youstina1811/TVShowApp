package sheridan.botrosy.tvshowapp.ui.theme.result

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
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sheridan.botrosy.tvshowapp.R
import sheridan.botrosy.tvshowapp.domain.Choice
import sheridan.botrosy.tvshowapp.domain.GameResult
import sheridan.botrosy.tvshowapp.ui.theme.common.ChoiceToImage
import sheridan.botrosy.tvshowapp.ui.theme.common.GameTopBar
import sheridan.botrosy.tvshowapp.ui.theme.common.choiceToString
import sheridan.botrosy.tvshowapp.ui.theme.common.resultToString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrizeScreen(
    userChoice: Choice,
    computerChoice: Choice,
    gameResult: GameResult,
    onReplay: () -> Unit,
    onHelpButtonClick: () -> Unit,
    onSelectAnother: (Choice) -> Unit // Add this parameter
) {
    Scaffold(
        topBar = {
            GameTopBar(
                title = stringResource(id = R.string.game_result),
                onHelpButtonClick = onHelpButtonClick,
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                onNavigateBack = onReplay
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = resultToString(gameResult = gameResult),
                fontSize = 32.sp,
                color = colorResource(id = R.color.orange_500)
            )
            // Add visuals for choices
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ChoiceToImage(choice = computerChoice)
                Text("versus")
                ChoiceToImage(choice = userChoice)
            }

            // Add the Select Another Box button
            Button(onClick = { onSelectAnother(Choice.UNKNOWN) }) { // Pass UNKNOWN or another choice as needed
                Text(text = "Select Another Box")
            }

            Button(onClick = onReplay) {
                Text(text = stringResource(R.string.replay), fontSize = 20.sp)
            }
        }
    }
}

