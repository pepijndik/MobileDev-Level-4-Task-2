package nl.pdik.level4.task2.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import nl.pdik.level4.task2.R
import nl.pdik.level4.task2.models.Game
import nl.pdik.level4.task2.viewmodel.GameViewModel
import androidx.compose.material.Divider as Divider1

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun HistoryScreen(navController: NavController, viewModel: GameViewModel) {
    val games: List<Game>? by viewModel.gamelog.observeAsState()
    val context = LocalContext.current;
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text =
                        stringResource(id = R.string.app_name) + " - " +
                                stringResource(
                                    id = R.string.title
                                )
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.deleteGameLogs();
            },
            Modifier.padding(bottom = 32.dp)) {
                Image(
                    painterResource(R.drawable.delete),
                    contentDescription = "delete"
                )
            }
        }


    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
            Games(
                games ?: arrayListOf(),
                modifier = Modifier.padding(2.dp),
                context
            )
        }
    }
}


@Composable
fun Games(
    games: List<Game>,
    modifier: Modifier,
    context:Context
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = games,
            itemContent = { game ->
                GameOutCome(game, context, true)
                Divider1(color = Color.Black, thickness = 1.dp)
            })
    }

}


