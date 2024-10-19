package sheridan.botrosy.tvshowapp.data

import sheridan.botrosy.tvshowapp.domain.Choice
import sheridan.botrosy.tvshowapp.domain.GameResult
import kotlin.random.Random

class GameService(
    private val random: Random = Random.Default
) {
    private val choices: List<Choice> = Choice.values().toList()

    fun getRandomChoice(): Choice =
        choices.filter { it != Choice.UNKNOWN }.random(random)

    fun getBoxContents(choice: Choice): String {
        return when (choice) {
            Choice.BOX1 -> "You found a treasure!"
            Choice.BOX2 -> "You found a note!"
            Choice.BOX3 -> "You found a map!"
            Choice.BOX4 -> "You found nothing."
            Choice.BOX5 -> "You found a magical item!"
            else -> "Unknown box."
        }
    }
}
