package sheridan.botrosy.tvshowapp.ui.theme.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import sheridan.botrosy.tvshowapp.R
import sheridan.botrosy.tvshowapp.domain.Choice

@Composable
fun ChoiceToImage(choice: Choice, modifier: Modifier = Modifier) {
    val resourceId = when (choice) {
        Choice.BOX1 -> R.drawable.box1
        Choice.BOX2 -> R.drawable.box2
        Choice.BOX3 -> R.drawable.box3
        Choice.BOX4 -> R.drawable.box4
        Choice.BOX5 -> R.drawable.box5
        else -> R.drawable.unknown // A default image for unknown choices
    }

    Image(
        painter = painterResource(id = resourceId),
        contentDescription = choiceToString(choice = choice),
        modifier = modifier.size(60.dp)
    )
}
