package sheridan.botrosy.tvshowapp.ui.theme.play

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import sheridan.botrosy.tvshowapp.ui.theme.common.GameTopBar
import sheridan.botrosy.tvshowapp.domain.Choice
import sheridan.botrosy.tvshowapp.data.GameService
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrizeScreen(
    userChoice: Choice,
    onHelpButtonClick: () -> Unit
) {
    Scaffold(
        topBar = {
            GameTopBar(
                title = "Your Prize",
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
                .padding(32.dp)
        ) {
            Text(text = "You chose: ${userChoice.name}")
            Text(text = "Prize: ${GameService().getBoxContents(userChoice)}")
        }
    }
}
