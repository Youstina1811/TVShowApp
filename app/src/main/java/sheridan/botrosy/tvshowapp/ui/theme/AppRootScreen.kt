@file:Suppress("UNREACHABLE_CODE")

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
            onSelectAnother = viewModel::onSelectAnother,
            onNext = viewModel::onNextPage,
            onHelpButtonClick = viewModel::onOpenHelp
        )
        Destination.PRIZE -> PrizeScreen(
            userChoice = uiState.userChoice,
            computerChoice = viewModel.getComputerChoice(),
            gameResult = viewModel.calculateGameResult(),
            onReplay = viewModel::onReplay,
            onHelpButtonClick = viewModel::onOpenHelp,
            onSelectAnother = viewModel::onSelectAnother // Pass the function here
        )
    }

    if (viewModel.showHelp) {
        AboutDialog(onDismissRequest = viewModel::onCloseHelp)
    }
}
