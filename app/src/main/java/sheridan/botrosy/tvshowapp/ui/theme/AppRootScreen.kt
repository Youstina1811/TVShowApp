package sheridan.botrosy.tvshowapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import sheridan.botrosy.tvshowapp.ui.theme.common.AboutDialog
import sheridan.botrosy.tvshowapp.ui.theme.play.PlayScreen
import sheridan.botrosy.tvshowapp.ui.theme.result.ResultScreen

@Composable
fun AppRootScreen(viewModel: GameViewModel = viewModel()) {

    val uiState: GameUiState by viewModel.gameUiState.collectAsState()

    when (uiState.destination) {
        Destination.PLAY -> PlayScreen(
            userChoice = uiState.userChoice,
            onUserChoiceChange = viewModel::onUserChoiceChange,
            onPlay = viewModel::onPlay,
            onHelpButtonClick = viewModel::onOpenHelp
        )

        Destination.RESULT -> ResultScreen(
            userChoice = uiState.userChoice,
            computerChoice = uiState.computerChoice,
            gameResult = uiState.gameResult,
            onReplay = viewModel::onReplay,
            onHelpButtonClick = viewModel::onOpenHelp
        )
    }

    if(viewModel.showHelp){
        AboutDialog(onDismissRequest = viewModel::onCloseHelp)
    }
}

