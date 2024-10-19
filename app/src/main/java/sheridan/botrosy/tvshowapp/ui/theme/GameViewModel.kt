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
        // Update the selected box and transition to the next screen
        _gameUiState.update { state ->
            state.copy(userChoice = choice, destination = Destination.CHOOSE_AGAIN)
        }
    }

    fun onKeepSelection() {
        // Logic for keeping the current selection and transitioning to the prize screen
        _gameUiState.update { state ->
            state.copy(destination = Destination.PRIZE)
        }
    }

    fun onSelectAnother(choice: Choice) {
        // Logic for selecting another box
        _gameUiState.update { state ->
            state.copy(userChoice = choice, destination = Destination.CHOOSE_AGAIN)
        }
    }

    fun onNextPage() {
        // Logic for transitioning to the prize screen after choosing again
        _gameUiState.update { state ->
            state.copy(destination = Destination.PRIZE)
        }
    }

    fun onReplay() {
        // Reset the game state to start over
        _gameUiState.update { GameUiState() }
    }

    fun onOpenHelp() {
        // Show help dialog
        showHelp = true
    }

    fun onCloseHelp() {
        // Hide help dialog
        showHelp = false
    }

    var showHelp: Boolean by mutableStateOf(false)
}