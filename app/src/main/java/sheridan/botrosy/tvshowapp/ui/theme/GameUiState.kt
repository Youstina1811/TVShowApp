package sheridan.botrosy.tvshowapp.ui.theme

import sheridan.botrosy.tvshowapp.domain.Choice
import sheridan.botrosy.tvshowapp.domain.GameResult

data class GameUiState(
    val destination: Destination = Destination.PLAY,
    val userChoice: Choice = Choice.UNKNOWN,
    val computerChoice: Choice = Choice.UNKNOWN,
    val gameResult: GameResult = GameResult.UNKNOWN
)

