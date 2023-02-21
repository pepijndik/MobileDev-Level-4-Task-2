package nl.pdik.level4.task2.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nl.pdik.level4.task2.ui.screens.HistoryScreen
import nl.pdik.level4.task2.ui.screens.PlayScreen
import nl.pdik.level4.task2.ui.screens.Screen
import nl.pdik.level4.task2.viewmodel.GameViewModel


@Composable
fun RockPaperScissorBottomNavigation(navController: NavHostController) {
    val navItems = listOf(
        Screen.HistoryScreen,
        Screen.PlayScreen,
    )
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        navItems.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = screen.icon),
                        contentDescription = screen.route
                    )
                },
                label = { Text(stringResource(screen.resourceId)) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationRockPaper(navController: NavHostController, viewModel: GameViewModel) {
    NavHost(
        navController,
        startDestination = Screen.PlayScreen.route,
    ) {
        composable(Screen.PlayScreen.route) { PlayScreen(navController, viewModel) }
        composable(Screen.HistoryScreen.route) { HistoryScreen(navController, viewModel) }
    }
}