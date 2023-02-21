package nl.pdik.level4.task2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import nl.pdik.level4.task2.ui.NavigationRockPaper
import nl.pdik.level4.task2.ui.RockPaperScissorBottomNavigation
import nl.pdik.level4.task2.ui.theme.RockPaperScissorsTheme
import nl.pdik.level4.task2.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RockPaperScissorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreenContent()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun MainScreenContent() {
    val navController = rememberNavController()
    val viewModel: GameViewModel = viewModel()
    Scaffold(
        bottomBar = { RockPaperScissorBottomNavigation(navController) }
    ) {
        NavigationRockPaper(navController, viewModel)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RockPaperScissorsTheme {

        MainScreenContent()
    }
}