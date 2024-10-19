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

class GameViewModel : ViewModel() {
    private val _gameUiState: MutableStateFlow<GameUiState> =
        MutableStateFlow(GameUiState())
    val gameUiState: StateFlow<GameUiState> = _gameUiState

    private val gameService: GameService = GameService()

    fun onBoxSelect(choice: Choice) {
        _gameUiState.update { state ->
            state.copy(userChoice = choice)
        }
    }

    fun onNextPage() {
        // Logic to handle page transitions
        // Update state accordingly
    }
}
