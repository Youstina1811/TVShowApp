package sheridan.botrosy.tvshowapp.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import sheridan.botrosy.tvshowapp.data.GameService
import sheridan.botrosy.tvshowapp.domain.Choice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import sheridan.botrosy.tvshowapp.domain.GameResult


class GameViewModel : ViewModel() {
    private val _gameUiState: MutableStateFlow<GameUiState> =
        MutableStateFlow(GameUiState())
    val gameUiState: StateFlow<GameUiState> = _gameUiState

    private val gameService: GameService = GameService()

    fun onBoxSelect(choice: Choice) {
        _gameUiState.update { state ->
            state.copy(userChoice = choice, destination = Destination.CHOOSE_AGAIN)
        }
    }

    fun onKeepSelection() {
        _gameUiState.update { state ->
            state.copy(destination = Destination.PRIZE)
        }
    }

    fun onSelectAnother(choice: Choice) {
        _gameUiState.update { state ->
            state.copy(userChoice = choice, destination = Destination.SELECT_BOX) // Navigate back to SELECT_BOX
        }
    }

    fun onNextPage() {
        _gameUiState.update { state ->
            state.copy(destination = Destination.PRIZE)
        }
    }

    fun onReplay() {
        _gameUiState.update { GameUiState() }
    }

    fun onOpenHelp() {
        showHelp = true
    }

    fun onCloseHelp() {
        showHelp = false
    }

    var showHelp: Boolean by mutableStateOf(false)

    fun getComputerChoice(): Choice {
        return gameService.getRandomChoice()
    }

    fun calculateGameResult(): GameResult {
        val userChoice = _gameUiState.value.userChoice
        val computerChoice = getComputerChoice() // This should be saved as a state

        // Add your game logic here
        return if (userChoice == computerChoice) {
            GameResult.USER_WINS
        } else {
            GameResult.COMPUTER_WINS
        }
    }
}