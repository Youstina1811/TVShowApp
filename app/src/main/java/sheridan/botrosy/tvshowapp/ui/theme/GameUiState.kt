package sheridan.botrosy.tvshowapp.ui.theme

import sheridan.botrosy.tvshowapp.domain.Choice
import sheridan.botrosy.tvshowapp.domain.GameResult

data class GameUiState(
    val destination: Destination = Destination.SELECT_BOX,
    val userChoice: Choice = Choice.UNKNOWN
)

