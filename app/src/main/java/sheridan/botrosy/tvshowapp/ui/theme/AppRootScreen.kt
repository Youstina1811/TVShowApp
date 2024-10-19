package sheridan.botrosy.tvshowapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import sheridan.botrosy.tvshowapp.ui.theme.common.AboutDialog
import sheridan.botrosy.tvshowapp.ui.theme.play.ChooseAgainScreen
import sheridan.botrosy.tvshowapp.ui.theme.play.SelectBoxScreen
import sheridan.botrosy.tvshowapp.ui.theme.result.PrizeScreen

@Composable
fun AppRootScreen(viewModel: GameViewModel = viewModel()) {
    val uiState: GameUiState by viewModel.gameUiState.collectAsState()

    when (uiState.destination) {
        Destination.SELECT_BOX -> SelectBoxScreen(
            selectedBox = uiState.userChoice,
            onBoxSelect = viewModel::onBoxSelect,
            onNext = viewModel::onNextPage,
            onHelpButtonClick = viewModel::onOpenHelp
        )
        Destination.CHOOSE_AGAIN -> ChooseAgainScreen(
            userChoice = uiState.userChoice,
            onKeep = viewModel::onKeepSelection,
            onSelectAnother = viewModel::onBoxSelect,
            onNext = viewModel::onNextPage,
            onHelpButtonClick = viewModel::onOpenHelp
        )
        Destination.PRIZE -> PrizeScreen(
            userChoice = uiState.userChoice,
            onHelpButtonClick = viewModel::onOpenHelp,
            computerChoice = TODO(),
            gameResult = TODO(),
            onReplay = TODO()
        )
    }

    if(viewModel.showHelp){
        AboutDialog(onDismissRequest = viewModel::onCloseHelp)
    }
}
