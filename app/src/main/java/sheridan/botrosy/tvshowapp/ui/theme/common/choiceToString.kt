package sheridan.botrosy.tvshowapp.ui.theme.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import sheridan.botrosy.tvshowapp.R
import sheridan.botrosy.tvshowapp.domain.Choice

@Composable
fun choiceToString(choice: Choice): String =
    when (choice) {
        Choice.BOX1 -> stringResource(id = R.string.box1)
        Choice.BOX2 -> stringResource(id = R.string.box2)
        Choice.BOX3 -> stringResource(id = R.string.box3)
        Choice.BOX4 -> stringResource(id = R.string.box4)
        Choice.BOX5 -> stringResource(id = R.string.box5)
        else -> stringResource(id = R.string.unknown)
    }
