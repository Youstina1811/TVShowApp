package sheridan.botrosy.tvshowapp.ui.theme

import sheridan.botrosy.tvshowapp.domain.Choice

data class GameUiState(
    val destination: Destination = Destination.SELECT_BOX,
    val userChoice: Choice = Choice.UNKNOWN
)

