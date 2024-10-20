@file:Suppress("UNREACHABLE_CODE")

package sheridan.botrosy.tvshowapp.ui.theme.play

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.botrosy.tvshowapp.domain.Choice
import sheridan.botrosy.tvshowapp.ui.theme.common.GameTopBar
import androidx.compose.material3.*

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import sheridan.botrosy.tvshowapp.R


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.graphicsLayer



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBoxScreen(
    selectedBox: Choice,
    onBoxSelect: (Choice) -> Unit,
    onNext: () -> Unit,
    onHelpButtonClick: () -> Unit
) {
    // Create a local state to hold the selected choice
    val selectedChoice = remember { mutableStateOf(Choice.UNKNOWN) }

    Scaffold(
        topBar = {
            GameTopBar(
                title = "Select a Box",
                onHelpButtonClick = onHelpButtonClick,
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                onNavigateBack = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Define the number of boxes per row
            val boxesPerRow = 3
            val boxes = Choice.values().filter { it != Choice.UNKNOWN }

            // Loop through the boxes and display them in rows
            boxes.chunked(boxesPerRow).forEach { rowBoxes ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    rowBoxes.forEach { box ->
                        Image(
                            painter = painterResource(id = getBoxImageResource(box)), // Use the function here
                            contentDescription = box.name,
                            modifier = Modifier
                                .size(120.dp) // Increased size of the image
                                .padding(8.dp) // Add some padding between images
                                .graphicsLayer(
                                    alpha = if (selectedChoice.value == box) 0.5f else 1f // Adjust opacity based on selection
                                )
                                .clickable {
                                    selectedChoice.value = box // Update the selected choice
                                    onBoxSelect(box) // Update the view model or perform other actions
                                }
                        )
                    }
                }
            }

            // Enable the Next button only if a box is selected
            Button(
                onClick = {
                    onNext() // Proceed to the next page
                },
                enabled = selectedChoice.value != Choice.UNKNOWN // Enable if a choice is made
            ) {
                Text("Next")
            }
        }
    }
}
// Function to get the resource ID for each box image
fun getBoxImageResource(choice: Choice): Int {
    return when (choice) {
        Choice.BOX1 -> R.drawable.box1
        Choice.BOX2 -> R.drawable.box2
        Choice.BOX3 -> R.drawable.box3
        Choice.BOX4 -> R.drawable.box4
        Choice.BOX5 -> R.drawable.box5
        else -> R.drawable.unknown // Fallback image
    }
}