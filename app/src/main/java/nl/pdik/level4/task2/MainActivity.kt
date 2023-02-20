package nl.pdik.level4.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nl.pdik.level4.task2.ui.NavigationRockPaper
import nl.pdik.level4.task2.ui.RockPaperScissorBottomNavigation
import nl.pdik.level4.task2.ui.screens.HistoryScreen
import nl.pdik.level4.task2.ui.screens.PlayScreen
import nl.pdik.level4.task2.ui.screens.Screen
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
                    ScreenContent()
                }
            }
        }
    }
}

@Composable
private fun ScreenContent() {
    val navController = rememberNavController()
    val viewModel: GameViewModel = viewModel()
    Scaffold(
        bottomBar = {
            RockPaperScissorBottomNavigation(navController);
        }
    ) { innerPadding ->
        NavigationRockPaper(navController, viewModel, modifier = Modifier.padding(innerPadding))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RockPaperScissorsTheme {
        ScreenContent()
    }
}