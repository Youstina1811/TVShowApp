package sheridan.botrosy.tvshowapp.ui.theme.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import sheridan.botrosy.tvshowapp.R
import sheridan.botrosy.tvshowapp.domain.GameResult

@Composable
fun resultToString(gameResult: GameResult): String =
    when (gameResult) {
        GameResult.USER_WINS -> stringResource(id = R.string.you_win)
        GameResult.COMPUTER_WINS -> stringResource(id = R.string.computer_wins)
        GameResult.REPLAY -> stringResource(id = R.string.play_again)
        GameResult.UNKNOWN -> stringResource(id = R.string.unknown_result)
    }
