package sheridan.botrosy.tvshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import sheridan.botrosy.tvshowapp.ui.theme.AppRootScreen
import sheridan.botrosy.tvshowapp.ui.theme.theme.TvShowAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TvShowAppTheme {
                AppRootScreen()
            }
        }
    }
}