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

    fun onPlay() {
        if(gameUiState.value.userChoice != Choice.UNKNOWN){
            val computerChoice = gameService.getRandomChoice()
            _gameUiState.update { state ->
                state.copy(
                    computerChoice = computerChoice,
                    gameResult = gameService.getGameResult(
                        userChoice = state.userChoice,
                        computerChoice = computerChoice
                    ),
                    destination = Destination.RESULT
                )
            }
        }
    }

    fun onReplay() {
        _gameUiState.update { state ->
            state.copy(destination = Destination.PLAY)
        }
    }

    fun onUserChoiceChange(newUserChoice: Choice) {
        _gameUiState.update { state ->
            state.copy(userChoice = newUserChoice)
        }
    }

    var showHelp: Boolean by mutableStateOf(false)
        private set

    fun onOpenHelp(){
        showHelp = true
    }

    fun onCloseHelp(){
        showHelp = false
    }
}