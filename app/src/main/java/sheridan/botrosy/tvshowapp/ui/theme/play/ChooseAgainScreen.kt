package sheridan.botrosy.tvshowapp.ui.theme.play

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
                onHelpButtonClick = onHelpButtonClick
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
